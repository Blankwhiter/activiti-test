package com.example.activititest.service.impl;

import java.awt.image.BufferedImage;
import java.io.*;
import	java.util.ArrayList;

import com.example.activititest.exception.GenericException;
import com.example.activititest.po.ActReProcDef;
import com.example.activititest.service.ActivitiDefineService;
import com.example.activititest.utils.Constant;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

/**
 * Service实现类
 *
 */
@Service("activitiDefineService")
public class ActivitiDefineServiceImpl implements ActivitiDefineService {


    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private IdentityService identityService;


    @Override
    public InputStream resourceRead(String id, String proInsId, String resType) {
        if (StringUtils.isBlank(id)) {
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(proInsId).singleResult();
            id = processInstance.getProcessDefinitionId();
        }
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(id).singleResult();

        String resourceName = "";
        if (Constant.IMAGE.equals(resType)) {
            resourceName = processDefinition.getDiagramResourceName();
        } else if (Constant.XML.equals(resType)) {
            resourceName = processDefinition.getResourceName();
        }

        InputStream resourceAsStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), resourceName);
        return resourceAsStream;
    }

    @Override
    public void startProcessInstanceById(String processDefinitionId,String assignee) {
        //设置发起人
        identityService.setAuthenticatedUserId(assignee);
        runtimeService.startProcessInstanceById(processDefinitionId);
    }

    @Override
    public List queryPage(Map<String, Object> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1").toString());
        int pageSize = Integer.parseInt(params.getOrDefault("pageSize", "10").toString());
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery().latestVersion().orderByProcessDefinitionKey().asc();

        // 按目录查找分类
        String category = params.get("category")==null?"":params.get("category").toString();
        if (StringUtils.isNotBlank(category)) {
            processDefinitionQuery.processDefinitionCategory(category);
        }
        // 按key查找分类
        String key =  params.get("key")==null?"":params.get("key").toString();
        if (StringUtils.isNotBlank(key)) {
            processDefinitionQuery.processDefinitionKey(key);
        }
        List<ProcessDefinition> processDefinitionList = processDefinitionQuery.listPage((page - 1) * pageSize, pageSize);

        List<ActReProcDef> list = new ArrayList<> ();

        for (ProcessDefinition processDefinition : processDefinitionList) {
            ActReProcDef  entity = new ActReProcDef();
            String deploymentId = processDefinition.getDeploymentId();
            Deployment deployment = repositoryService.createDeploymentQuery().deploymentId(deploymentId).singleResult();
            entity.setId(processDefinition.getId());
            entity.setKey(processDefinition.getKey());
            entity.setName(deployment == null ? "" : StringUtils.isBlank(deployment.getName()) ? processDefinition.getName() : deployment.getName());
            entity.setDeployTime(deployment == null ? null : deployment.getDeploymentTime());
            entity.setDeploymentId(processDefinition.getDeploymentId());
            entity.setSuspensionState(processDefinition.isSuspended() ? Constant.TWO : Constant.ONE);
            entity.setResourceName(processDefinition.getResourceName());
            entity.setDgrmResourceName(processDefinition.getDiagramResourceName());
            entity.setCategory(processDefinition.getCategory());
            entity.setVersion(processDefinition.getVersion());
            entity.setDescription(processDefinition.getDescription());
            entity.setEngineVersion(processDefinition.getEngineVersion());
            entity.setTenantId(processDefinition.getTenantId());
            list.add(entity);
        }
        return list;

    }

    @Override
    public void delete(String id) {
        repositoryService.deleteDeployment(id, false);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(String[] deploymentIds) {
        for (String deploymentId : deploymentIds) {
            repositoryService.deleteDeployment(deploymentId, false);
        }
    }

    @Override
    public String deploy(String exportDir, MultipartFile file) throws IOException {
        StringBuilder message = new StringBuilder();

        String fileName = file.getOriginalFilename();

        InputStream fileInputStream = file.getInputStream();
        Deployment deployment = null;
        String extension = FilenameUtils.getExtension(fileName);
        if (Constant.ZIP.equals(extension) || Constant.BAR.equals(extension)) {
            ZipInputStream zip = new ZipInputStream(fileInputStream);
            deployment = repositoryService.createDeployment().addZipInputStream(zip).deploy();
        } else if (Constant.PNG.equals(extension)) {
            deployment = repositoryService.createDeployment().addInputStream(fileName, fileInputStream).deploy();
        } else if (fileName.indexOf(Constant.BPMN20) != -1) {
            deployment = repositoryService.createDeployment().addInputStream(fileName, fileInputStream).deploy();
        } else if (Constant.BPMN.equals(extension)) {
            deployment = repositoryService.createDeployment().addInputStream(fileName, fileInputStream).deploy();
        } else {
            message = new StringBuilder("不支持的文件类型：" + extension);
        }

        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).list();

        // 设置流程分类
        for (ProcessDefinition processDefinition : list) {
            repositoryService.setProcessDefinitionCategory(processDefinition.getId(), processDefinition.getCategory());
            message.append("部署成功，流程ID=").append(processDefinition.getId()).append("<br/>");
        }

        if (list.size() == 0) {
            message = new StringBuilder("部署失败，没有流程。");
        }
        return message.toString();
    }

    @Override
    public Model convertToModel(String id) throws UnsupportedEncodingException, XMLStreamException {
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(id).singleResult();
        InputStream bpmnStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), processDefinition.getResourceName());
        XMLInputFactory xif = XMLInputFactory.newInstance();
        InputStreamReader in = new InputStreamReader(bpmnStream, "UTF-8");
        XMLStreamReader xtr = xif.createXMLStreamReader(in);
        BpmnModel bpmnModel = new BpmnXMLConverter().convertToBpmnModel(xtr);

        BpmnJsonConverter converter = new BpmnJsonConverter();
        ObjectNode modelNode = converter.convertToJson(bpmnModel);
        Model modelData = repositoryService.newModel();
        modelData.setKey(processDefinition.getKey());
        modelData.setName(processDefinition.getResourceName());
        modelData.setCategory(processDefinition.getCategory());
        modelData.setDeploymentId(processDefinition.getDeploymentId());
        modelData.setVersion(Integer.parseInt(String.valueOf(repositoryService.createModelQuery().modelKey(modelData.getKey()).count() + 1)));

        ObjectNode modelObjectNode = new ObjectMapper().createObjectNode();
        modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, processDefinition.getName());
        modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, modelData.getVersion());
        modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, processDefinition.getDescription());
        modelData.setMetaInfo(modelObjectNode.toString());

        repositoryService.saveModel(modelData);

        repositoryService.addModelEditorSource(modelData.getId(), modelNode.toString().getBytes("utf-8"));
        return modelData;
    }

    @Override
    public String updateState(int state, String id) {
        String msg = "无操作";
        if (state == Constant.ONE) {
            try {
                repositoryService.activateProcessDefinitionById(id, true, null);
            } catch (Exception e) {
                throw new GenericException("流程已经激活");
            }
            msg = "已激活ID为[" + id + "]的流程定义。";
        } else if (state == Constant.TWO) {
            try {
                repositoryService.suspendProcessDefinitionById(id, true, null);
            } catch (Exception e) {
                throw new GenericException("流程已经挂起");
            }
            msg = "已挂起ID为[" + id + "]的流程定义。";
        }
        return msg;
    }

    @Override
    public void viewProcessImage(String id, HttpServletResponse response) {
        InputStream inputStream = repositoryService.getProcessDiagram(id);
        try {
            BufferedImage image  = ImageIO.read(inputStream);
            ServletOutputStream outputStream = response.getOutputStream();
            ImageIO.write(image,"png",outputStream);
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
