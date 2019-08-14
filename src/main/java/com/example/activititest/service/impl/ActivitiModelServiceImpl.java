package com.example.activititest.service.impl;

import com.example.activititest.exception.GenericException;
import com.example.activititest.po.ActReModel;
import com.example.activititest.service.ActivitiModelService;
import com.example.activititest.utils.Constant;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ModelQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 */
@Service("activitiModelService")
public class ActivitiModelServiceImpl implements ActivitiModelService {
    @Autowired
    private RepositoryService repositoryService;

    @Override
    public List queryPage(Map<String, Object> params) {
        int page = Integer.parseInt((String) params.get("page"));
        int pageSize = Integer.parseInt((String) params.get("pageSize"));

        ModelQuery modelQuery = repositoryService.createModelQuery().latestVersion().orderByLastUpdateTime().desc();
        String key =params.get("key")==null?"": params.get("key").toString();
        if (StringUtils.isNotBlank(key)) {
            modelQuery.modelKey(key);
        }
        List<Model> list = modelQuery.listPage((page - 1) * pageSize, pageSize);
        return list;
    }

    @Override
    public Model add(ActReModel actReModel) throws UnsupportedEncodingException {
        String description = actReModel.getDescription();
        String key = actReModel.getKey();
        String name = actReModel.getName();

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode editorNode = objectMapper.createObjectNode();
        editorNode.put("id", "canvas");
        editorNode.put("resourceId", "canvas");
        ObjectNode stencilSetNode = objectMapper.createObjectNode();
        stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
        editorNode.set("stencilset", stencilSetNode);
        Model modelData = repositoryService.newModel();

        description = StringUtils.defaultString(description);
        modelData.setKey(StringUtils.defaultString(key));
        modelData.setName(name);
        modelData.setVersion(Integer.parseInt(String.valueOf(repositoryService.createModelQuery()
                .modelKey(modelData.getKey()).count() + 1)));

        ObjectNode modelObjectNode = objectMapper.createObjectNode();
        modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, name);
        modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, modelData.getVersion());
        modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
        modelData.setMetaInfo(modelObjectNode.toString());

        repositoryService.saveModel(modelData);
        repositoryService.addModelEditorSource(modelData.getId(), editorNode.toString().getBytes("utf-8"));

        return modelData;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String deploy(String id) {
        String message = "";
        try {
            Model modelData = repositoryService.getModel(id);
            BpmnJsonConverter jsonConverter = new BpmnJsonConverter();
            JsonNode editor = new ObjectMapper().readTree(repositoryService.getModelEditorSource(modelData.getId()));
            BpmnModel bpmnModel = jsonConverter.convertToBpmnModel(editor);
            BpmnXMLConverter xmlConverter = new BpmnXMLConverter();
            byte[] bpmnBytes = xmlConverter.convertToXML(bpmnModel);

            String processName = modelData.getName();
            if (!StringUtils.endsWith(processName, Constant.BPMN20)) {
                processName += Constant.BPMN20;
            }
            ByteArrayInputStream in = new ByteArrayInputStream(bpmnBytes);
            Deployment deployment = repositoryService.createDeployment()
                    .name(modelData.getName())
                    .addInputStream(processName, in)
                    .deploy();
            // 设置流程分类
            List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).list();
            for (ProcessDefinition processDefinition : list) {
                repositoryService.setProcessDefinitionCategory(processDefinition.getId(), modelData.getCategory());
                message = "部署成功，流程ID=" + processDefinition.getId();
            }
            if (list.size() == 0) {
                message = "部署失败，没有流程。";
            }
        } catch (Exception e) {
            throw new ActivitiException("设计模型图不正确，检查模型正确性，模型ID=" + id, e);
        }
        return message;
    }

    @Override
    public void export(String id, HttpServletResponse response) {
        try {
            Model modelData = repositoryService.getModel(id);
            BpmnJsonConverter jsonConverter = new BpmnJsonConverter();
            JsonNode editor = new ObjectMapper().readTree(repositoryService.getModelEditorSource(modelData.getId()));
            BpmnModel bpmnModel = jsonConverter.convertToBpmnModel(editor);
            BpmnXMLConverter xmlConverter = new BpmnXMLConverter();
            byte[] bpmnBytes = xmlConverter.convertToXML(bpmnModel);

            ByteArrayInputStream in = new ByteArrayInputStream(bpmnBytes);
            IOUtils.copy(in, response.getOutputStream());
            String filename = URLEncoder.encode(bpmnModel.getMainProcess().getName() + ".bpmn20.xml", "UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename="
                    + filename);
            response.flushBuffer();
        } catch (Exception e) {
            throw new GenericException("导出model的xml文件失败，模型ID=" + id, e);
        }

    }

    @Override
    public void delete(String id) {
        repositoryService.deleteModel(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(String[] ids) {
        for (String id : ids) {
            repositoryService.deleteModel(id);
        }
    }
}
