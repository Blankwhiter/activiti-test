package com.example.activititest.controller;

import com.example.activititest.base.ResultDTO;
import com.example.activititest.service.ActivitiTaskService;
import com.example.activititest.utils.ResultUtils;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("task")
public class ActivitTaskController {

    @Autowired
    private ActivitiTaskService activitiTaskService;


    /**
     * 获得待签事务列表
     * @param params
     * @return
     */
    @RequestMapping(value="/claimList")
    public ResultDTO  claimList(@RequestParam Map<String, Object> params){
        List<Task> list = activitiTaskService.querySignPage(params);
        List<Map<String, Object>> mapList = list.stream().map(task -> {
            try {
                HashMap<String, Object> map = new HashMap<>();
                map.put("id",task.getId());
                map.put("createTime",task.getCreateTime());
                map.put("name",task.getName());
                map.put("category",task.getCategory());
                return map;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
        return ResultUtils.getSuccess(mapList);
    }

    /**
     * 获得待签事务列表
     * @param params
     * @return
     */
    @RequestMapping("/todoList")
    public ResultDTO  todoList(@RequestParam Map<String, Object> params){
        List<Task> list = activitiTaskService.queryTodoPage(params);
        List<Map<String, Object>> mapList = list.stream().map(task -> {
            try {
                HashMap<String, Object> map = new HashMap<>();
                map.put("id",task.getId());
                map.put("createTime",task.getCreateTime());
                map.put("name",task.getName());
                map.put("category",task.getCategory());
                return map;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
        return ResultUtils.getSuccess(mapList);
    }

    /**
     * 获得已发事务列表
     * @param params
     * @return
     */
    @RequestMapping("/sentList")
    public ResultDTO  sentList(@RequestParam Map<String, Object> params){
        List list = activitiTaskService.querySentPage(params);
        return ResultUtils.getSuccess(list);
    }



    /**
     * 查看登陆用户 参与过的办结任务
     * @param params
     * @return
     */
    @RequestMapping("/finishList")
    public ResultDTO  finishList(@RequestParam Map<String, Object> params){
        List list = activitiTaskService.queryFinishPage(params);
        return ResultUtils.getSuccess(list);
    }

    /**
     * 登陆用户 签收任务
     * @param taskId  任务id
     * @param assignee 当前用户
     * @return
     */
    @RequestMapping("/claim")
    public ResultDTO  claim(String taskId,String assignee){
        activitiTaskService.claim(taskId,assignee);
        return ResultUtils.getSuccess(null);
    }
    /**
     * 获得对应任务的所有批注
     * @param taskId  任务id
     * @return
     */
    @RequestMapping("/commentList")
    public ResultDTO  commentList(String taskId ){
        activitiTaskService.queryCommentPage(taskId);
        return ResultUtils.getSuccess(null);
    }

    /**
     * 登陆用户 完成任务
     * @param taskId  任务id
     * @param  params  包含：当前用户 跟 批注
     * @return
     */
    @RequestMapping("/complete")
    public ResultDTO  complete(String taskId,@RequestParam Map<String, Object> params){
        activitiTaskService.complete(taskId,params);
        return ResultUtils.getSuccess(null);
    }



    /**
     * 根据任务id 获得对应的流程图 包含流程记录路线
     * @param processInstanceId  任务id
     * @param response
     * @return
     */
    @RequestMapping("/viewProgressPathImage")
    public void  viewProgressPathImage(String processInstanceId, HttpServletResponse response){
        activitiTaskService.getActivitiProccessImage(processInstanceId,response);
    }



}
