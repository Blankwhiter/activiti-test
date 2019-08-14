package com.example.activititest.service;

import org.activiti.engine.repository.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * 流程定义Service接口
 *
 */
public interface ActivitiDefineService {
    /**
     * 通过部署ID读取资源
     *
     * @param id       流程部署标识
     * @param proInsId 流程实例表示
     * @param resType  部署文件类型
     * @return 文件流
     */
    InputStream resourceRead(String id, String proInsId, String resType);

    /**
     * 启动流程实例，通过processDefinitionId
     *
     * @param processDefinitionId
     * @param assignee 发起人
     */
    void startProcessInstanceById(String processDefinitionId,String assignee);

    /**
     * 分页查询
     *
     * @param params 查询参数
     * @return List
     */
    List queryPage(Map<String, Object> params);

    /**
     * 删除部署流程
     *
     * @param deploymentId 流程部署标识
     */
    void delete(String deploymentId);

    /**
     * 删除部署流程
     *
     * @param deploymentIds 流程部署标识
     */
    void deleteBatch(String[] deploymentIds);

    /**
     * 根据文件部署工作流
     *
     * @param exportDir 文件地址
     * @param file      上传文件
     * @return 部署信息
     * @throws IOException
     */
    String deploy(String exportDir, MultipartFile file) throws IOException;

    /**
     * 转为模型
     *
     * @param id id
     * @return Model
     * @throws UnsupportedEncodingException
     * @throws XMLStreamException
     */
    Model convertToModel(String id) throws UnsupportedEncodingException, XMLStreamException;


    /**
     * 流程挂起和激活
     *
     * @param state 流程状态
     * @param id    流程部署标识
     * @return 操作信息
     */
    String updateState(int state, String id);


    /**
     * 查看流程图
     * @param id
     * @param response
     */
    void viewProcessImage(String id, HttpServletResponse response);


}
