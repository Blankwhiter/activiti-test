
package com.example.activititest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.commons.io.IOUtils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * ActivitiServiceController
 * 流程建模编辑器控制类
 * @RequestMapping("/visual") 对应 src\main\resources\static\editor-app\app-cfg.js 24行
 */
@RestController
@RequestMapping("/visual")
public class ActivitiVisualController {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private RepositoryService repositoryService;

    /**
     * stencilset   对应src\\main\\resources\\static\\editor-app\\configuration\\url-config.js 24行
     * 找出定义的模具集合
     * @return stencilset.json
     */
    @RequestMapping("/editor/stencilset")
    public String getStencilset() {
        InputStream stencilsetStream = this.getClass().getResourceAsStream("/static/stencilset.json");
        try {
            return IOUtils.toString(stencilsetStream, "utf-8");
        } catch (Exception e) {
            throw new ActivitiException("Error while loading stencil set", e);
        }
    }

    /**
     * 模型详情 对应src\\main\\resources\\static\\editor-app\\configuration\\url-config.js 28行
     *
     * @param modelId
     * @return
     */
    @RequestMapping("/model/{modelId}/json")
    public ObjectNode getEditorJson(@PathVariable String modelId) {
        ObjectNode modelNode = null;

        Model model = repositoryService.getModel(modelId);

        if (model != null) {
            try {
                if (StringUtils.isNotEmpty(model.getMetaInfo())) {
                    modelNode = (ObjectNode) objectMapper.readTree(model.getMetaInfo());
                } else {
                    modelNode = objectMapper.createObjectNode();
                    modelNode.put("name", model.getName());
                }
                modelNode.put("modelId", model.getId());
                ObjectNode editorJsonNode = (ObjectNode) objectMapper.readTree(
                        new String(repositoryService.getModelEditorSource(model.getId()), "utf-8"));
                modelNode.set("model", editorJsonNode);

            } catch (Exception e) {
                throw new ActivitiException("Error creating model JSON", e);
            }
        }
        return modelNode;
    }

    /**
     * 保存模型 对应src\\main\\resources\\static\\editor-app\\configuration\\url-config.js 32行
     *
     * @param modelId
     * @param name
     * @param jsonXml
     * @param svgXml
     * @param description
     */
    @RequestMapping("/model/{modelId}/save")
    public void saveModel(@PathVariable String modelId, @RequestParam("name") String name,
                          @RequestParam("json_xml") String jsonXml, @RequestParam("svg_xml") String svgXml,
                          @RequestParam("description") String description) {
        try {
            Model model = repositoryService.getModel(modelId);
            ObjectNode modelJson = (ObjectNode) objectMapper.readTree(model.getMetaInfo());
            modelJson.put("name", name);
            modelJson.put("description", description);
            model.setMetaInfo(modelJson.toString());
            model.setName(name);
            repositoryService.saveModel(model);
            repositoryService.addModelEditorSource(model.getId(), jsonXml.getBytes(StandardCharsets.UTF_8));

            InputStream svgStream = new ByteArrayInputStream(svgXml.getBytes(StandardCharsets.UTF_8));
            TranscoderInput input = new TranscoderInput(svgStream);
            PNGTranscoder transcoder = new PNGTranscoder();
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            TranscoderOutput output = new TranscoderOutput(outStream);
            transcoder.transcode(input, output);
            final byte[] result = outStream.toByteArray();
            repositoryService.addModelEditorSourceExtra(model.getId(), result);
            outStream.close();
        } catch (Exception e) {
            throw new ActivitiException("Error saving model", e);
        }
    }
}
