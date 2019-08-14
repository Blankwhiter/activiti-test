package com.example.activititest.service.impl;

import com.example.activititest.config.MyProcessDiagramGenerator;
import com.example.activititest.exception.GenericException;
import com.example.activititest.service.ActivitiTaskService;
import lombok.extern.slf4j.Slf4j;
import org.activiti.bpmn.model.*;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.activiti.image.ProcessDiagramGenerator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("activitiTaskService")
public class ActivitiTaskServiceImpl implements ActivitiTaskService {

    @Autowired
    private TaskService taskService;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private ProcessEngine processEngine;


    @Override
    public List<Task> querySignPage(Map<String, Object> params) {
        int page = Integer.parseInt((String) params.get("page"));
        int pageSize = Integer.parseInt((String) params.get("pageSize"));
        //当前用户assignee获得对应的角色组，此处为了方便测试从前台传入
        String group = String.valueOf(params.get("group"));
        List<Task> list = taskService.createTaskQuery().taskUnassigned().taskCandidateGroup(group).orderByTaskCreateTime().desc().listPage((page - 1) * pageSize, pageSize);
        return list;
    }

    @Override
    public List<HistoricProcessInstance> querySentPage(Map<String, Object> params) {
        int page = Integer.parseInt((String) params.get("page"));
        int pageSize = Integer.parseInt((String) params.get("pageSize"));
        //当前用户assignee，此处为了方便测试从前台传入
        String assignee = String.valueOf(params.get("assignee"));
        List<HistoricProcessInstance> list = historyService.createHistoricProcessInstanceQuery().startedBy(assignee).listPage((page - 1) * pageSize, pageSize);
        return list;
    }

    @Override
    public List<HistoricProcessInstance> queryFinishPage(Map<String, Object> params) {
        int page = Integer.parseInt((String) params.get("page"));
        int pageSize = Integer.parseInt((String) params.get("pageSize"));
        //当前用户assignee，此处为了方便测试从前台传入
        String assignee = String.valueOf(params.get("assignee"));
        List<HistoricProcessInstance> list = historyService.createHistoricProcessInstanceQuery().involvedUser(assignee).finished().listPage((page - 1) * pageSize, pageSize);
        return list;
    }

    @Override
    public void claim(String id, String assignee) {
        //当前用户assignee，此处为了方便测试从前台传入
        taskService.claim(id, assignee);
    }

    @Override
    public List queryTodoPage(Map<String, Object> params) {
        int page = Integer.parseInt((String) params.get("page"));
        int pageSize = Integer.parseInt((String) params.get("pageSize"));
        //当前用户assignee，此处为了方便测试从前台传入 获得待办任务以及签收的任务
        String assignee = String.valueOf(params.get("assignee"));
        List<Task> list = taskService.createTaskQuery().taskCandidateOrAssigned(assignee).orderByTaskCreateTime().desc().listPage((page - 1) * pageSize, pageSize);
        return list;
    }

    @Override
    public void complete(String taskId, Map<String, Object> params) {
        //批注信息
        Object comment = params.get("comment");
        Object assignee = params.get("assignee");
        if (comment != null && StringUtils.isNotBlank(String.valueOf(comment))) {
            // 1.根据任务ID查询任务实例
            Task task = this.taskService.createTaskQuery().taskId(taskId).singleResult();
            // 2.从任务里面取出流程实例ID
            String processInstanceId = task.getProcessInstanceId();
            //3.设置批注人
            Authentication.setAuthenticatedUserId(String.valueOf(assignee));
            taskService.addComment(taskId, processInstanceId, String.valueOf(comment));
        }
        //将其他参数参入 可控制流程走向
        params.remove("comment");
        params.remove("assignee");
        taskService.complete(taskId,params);
    }

    @Override
    public List queryCommentPage(String taskId) {
        // 1,根据任务ID查询任务实例
        Task task = this.taskService.createTaskQuery().taskId(taskId).singleResult();
        // 2,从任务里面取出流程实例ID
        String processInstanceId = task.getProcessInstanceId();
        List<Comment> list = taskService.getProcessInstanceComments(processInstanceId);
        return list;
    }



    /**
     * 通过任务id 获取流程图像，已执行节点和流程线高亮显示
     */
    @Override
    public void getActivitiProccessImage(String processInstanceId, HttpServletResponse response) {
        log.info("[开始]-获取流程图图像");
        try {
            //  获取历史流程实例
            HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery()
                    .processInstanceId(processInstanceId).singleResult();

            if (historicProcessInstance == null) {
                throw new GenericException("获取流程实例ID[" + processInstanceId + "]对应的历史流程实例失败！");
            } else {
                // 获取流程定义
                ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
                        .getDeployedProcessDefinition(historicProcessInstance.getProcessDefinitionId());

                // 获取流程历史中已执行节点，并按照节点在流程中执行先后顺序排序
                List<HistoricActivityInstance> historicActivityInstanceList = historyService.createHistoricActivityInstanceQuery()
                        .processInstanceId(processInstanceId).orderByHistoricActivityInstanceId().asc().list();

                // 已执行的节点ID集合
                List<String> executedActivityIdList = new ArrayList<String>();
                int index = 1;
                log.info("获取已经执行的节点ID");
                for (HistoricActivityInstance activityInstance : historicActivityInstanceList) {
                    executedActivityIdList.add(activityInstance.getActivityId());
                    log.info("第[" + index + "]个已执行节点=" + activityInstance.getActivityId() + " : " + activityInstance.getActivityName());
                    index++;
                }

                BpmnModel bpmnModel = repositoryService.getBpmnModel(historicProcessInstance.getProcessDefinitionId());

                // 已执行的线集合
                List<String> flowIds = new ArrayList<String>();
                // 获取流程走过的线 (getHighLightedFlows是下面的方法)
                flowIds = getHighLightedFlows(bpmnModel, processDefinition, historicActivityInstanceList);

                // 获取流程图图像字符流
                processEngine.getProcessEngineConfiguration().setProcessDiagramGenerator(new MyProcessDiagramGenerator());
                ProcessDiagramGenerator pec = processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator();
                //配置字体
                InputStream imageStream = pec.generateDiagram(bpmnModel, "png", executedActivityIdList, flowIds, "宋体", "微软雅黑", "黑体", null, 2.0);

                response.setContentType("image/png");
                OutputStream os = response.getOutputStream();
                int bytesRead = 0;
                byte[] buffer = new byte[8192];
                while ((bytesRead = imageStream.read(buffer, 0, 8192)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
                os.close();
                imageStream.close();
            }
            log.info("[完成]-获取流程图图像");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            log.error("【异常】-获取流程图失败！" + e.getMessage());
            throw new GenericException("获取流程图失败！" + e.getMessage());
        }
    }



    public List<String> getHighLightedFlows(BpmnModel bpmnModel, ProcessDefinitionEntity processDefinitionEntity, List<HistoricActivityInstance> historicActivityInstances) {
        //24小时制
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 用以保存高亮的线flowId
        List<String> highFlows = new ArrayList<>();

        for (int i = 0; i < historicActivityInstances.size() - 1; i++) {
            // 对历史流程节点进行遍历
            // 得到节点定义的详细信息
            FlowNode activityImpl = (FlowNode) bpmnModel.getMainProcess().getFlowElement(historicActivityInstances.get(i).getActivityId());

            // 用以保存后续开始时间相同的节点
            List<FlowNode> sameStartTimeNodes = new ArrayList<>();
            FlowNode sameActivityImpl1 = null;

            // 第一个节点
            HistoricActivityInstance activityImpl_ = historicActivityInstances.get(i);
            HistoricActivityInstance activityImp2_;

            for (int k = i + 1; k <= historicActivityInstances.size() - 1; k++) {
                // 后续第1个节点
                activityImp2_ = historicActivityInstances.get(k);

                //都是usertask，且主节点与后续节点的开始时间相同，说明不是真实的后继节点
                if (activityImpl_.getActivityType().equals("userTask") && activityImp2_.getActivityType().equals("userTask") &&
                        df.format(activityImpl_.getStartTime()).equals(df.format(activityImp2_.getStartTime())))
                {

                } else {//找到紧跟在后面的一个节点
                    sameActivityImpl1 = (FlowNode) bpmnModel.getMainProcess().getFlowElement(historicActivityInstances.get(k).getActivityId());
                    break;
                }
            }
            // 将后面第一个节点放在时间相同节点的集合里
            sameStartTimeNodes.add(sameActivityImpl1);
            for (int j = i + 1; j < historicActivityInstances.size() - 1; j++) {
                // 后续第一个节点
                HistoricActivityInstance activityImpl1 = historicActivityInstances.get(j);
                // 后续第二个节点
                HistoricActivityInstance activityImpl2 = historicActivityInstances.get(j + 1);
                // 如果第一个节点和第二个节点开始时间相同保存
                if (df.format(activityImpl1.getStartTime()).equals(df.format(activityImpl2.getStartTime()))) {
                    FlowNode sameActivityImpl2 = (FlowNode) bpmnModel.getMainProcess().getFlowElement(activityImpl2.getActivityId());
                    sameStartTimeNodes.add(sameActivityImpl2);
                } else {// 有不相同跳出循环
                    break;
                }
            }
            // 取出节点的所有出去的线
            List<SequenceFlow> pvmTransitions = activityImpl.getOutgoingFlows();
            // 对所有的线进行遍历
            for (SequenceFlow pvmTransition : pvmTransitions) {
                // 如果取出的线的目标节点存在时间相同的节点里，保存该线的id，进行高亮显示
                FlowNode pvmActivityImpl = (FlowNode) bpmnModel.getMainProcess().getFlowElement(pvmTransition.getTargetRef());
                if (sameStartTimeNodes.contains(pvmActivityImpl)) {
                    highFlows.add(pvmTransition.getId());
                }
            }

        }
        return highFlows;

    }


}
