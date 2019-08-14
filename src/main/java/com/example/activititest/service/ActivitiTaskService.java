package com.example.activititest.service;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 任务相关接口
 */
public interface ActivitiTaskService {
    /**
     * 分页查询 待办任务
     *
     * @param params 查询参数
     * @return List
     */
    List<Task> queryTodoPage(Map<String, Object> params);

    /**
     * 分页查询 待签任务
     *
     * @param params 查询参数
     * @return List
     */
    List<Task> querySignPage(Map<String, Object> params);


    /**
     *  签收任务
     * @param taskId 任务标识
     * @param assignee 任务签收人
     * @return
     */
    void claim(String taskId,String assignee);

    /**
     *  完成任务
     * @param taskId 任务标识
     * @param params 需要往下个任务人 传递参数
     * @return
     */
    void complete(String taskId,Map<String,Object> params);

    /**
     * 分页查询
     *
     * @param taskId 查询参数 包含id ：任务标识
     * @return List
     */
    List<Comment> queryCommentPage(String taskId);

    /**
     * 根据任务id 获得对应的流程图
     * @param taskId 任务id
     * @return
     */
    void getActivitiProccessImage(String taskId, HttpServletResponse response);

    /**
     * 查看登陆用户已发任务
     * @param params
     * @return
     */
    List<HistoricProcessInstance> querySentPage(Map<String, Object> params);

   /**
     * 查看登陆用户 参与过的办结任务
     * @param params
    * @return
     */
    List<HistoricProcessInstance> queryFinishPage(Map<String, Object> params);

}
