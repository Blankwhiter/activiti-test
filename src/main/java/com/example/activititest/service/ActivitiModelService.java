package com.example.activititest.service;

import com.example.activititest.po.ActReModel;
import com.github.pagehelper.PageInfo;
import org.activiti.engine.repository.Model;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * 模型Service接口
 *
 */
public interface ActivitiModelService {

    /**
     * 分页查询
     *
     * @param params 查询参数
     * @return List
     */
    List queryPage(Map<String, Object> params);

    /**
     * 新增
     *
     * @param actReModel
     * @return 新增结果
     * @throws UnsupportedEncodingException
     */
    Model add(ActReModel actReModel) throws UnsupportedEncodingException;

    /**
     * 部署工作流模型
     *
     * @param id 模型标识
     * @return 部署信息
     */
    String deploy(String id);

    /**
     * 导出XML
     *
     * @param id       流程模型标识
     * @param response 响应
     */
    void export(String id, HttpServletResponse response);

    /**
     * 根据主键删除
     *
     * @param id id
     */
    void delete(String id);

    /**
     * 根据主键批量删除
     *
     * @param ids ids
     */
    void deleteBatch(String[] ids);
}
