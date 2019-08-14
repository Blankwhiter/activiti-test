package com.example.activititest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.*;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.imageio.ImageIO;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * activiti 测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ActivitiTestApplicationTests {

    @Test
    public void contextLoads() {
        //启动引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();//会去创建表
        //存储服务
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //运行服务
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //任务服务
        TaskService taskService = processEngine.getTaskService();
        //部署流程 需要 bpmn 后缀文件，
        // 说明addClasspathResoure加载某个资源，
        // addZipInputStream 加载一个压缩包可以多个文件，
        // addBpmnModel 加入一个bpmn实例，动态生成流程文件存到act_ge_bytearray表中
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment().addClasspathResource("bpmn/first.bpmn");
        deploymentBuilder.disableSchemaValidation();//关闭验证格式是否正确
        deploymentBuilder.disableBpmnValidation();//关闭验证流程是否正确
        Deployment deployment = deploymentBuilder.deploy();
        //查找流程实例
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();
        ProcessInstance process1 = runtimeService.startProcessInstanceById(processDefinition.getId());

        Task task = taskService.createTaskQuery().processInstanceId(process1.getId()).singleResult();
        log.info(" 当前流程：{}" ,task.getName());
        taskService.complete(task.getId());

        task = taskService.createTaskQuery().processInstanceId(process1.getId()).singleResult();
        log.info(" 当前流程：{}" ,task.getName());
        taskService.complete(task.getId());

        processEngine.close();
    }

    /**
     *  测试用户组添加
     */
    @Test
    public void addGroup(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        IdentityService identityService = processEngine.getIdentityService();
        for (int i = 0; i < 10; i++) {
            Group group = identityService.newGroup(String.valueOf(i));
            group.setName("group_" + i);
            group.setType("type_"+i);
            identityService.saveGroup(group);
        }
        processEngine.close();
    }

    /**
     * 获得用户组列表
     */
    @Test
    public void getGroupList(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        IdentityService identityService = processEngine.getIdentityService();
        List<Group> list = identityService.createGroupQuery().list();
        for (Group group :
                list) {
            log.info("group name is {}",group.getName());
        }
    }

    /**
     * 获得用户组排序列表
     */
    @Test
    public void getGroupListOrderBy(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        IdentityService identityService = processEngine.getIdentityService();
        //asc  desc需要跟orderby使用  如果多字段排序需要每个order by需要跟上desc或者asc
        List<Group> list = identityService.createGroupQuery().orderByGroupName().desc().list();
        for (Group group :
                list) {
            log.info("group name is {}",group.getName());
        }
    }

    /**
     * 根据查询条件查询用户组
     */
    @Test
    public void getGroupSelect(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        IdentityService identityService = processEngine.getIdentityService();
        // 通过对应字段 进行进行查询 如果多个字段跟在后面即可
        List<Group> list = identityService.createGroupQuery().groupName("group_1").list();
        for (Group group :
                list) {
            log.info("group name is {}",group.getName());
        }
    }

    /**
     *  使用原生语句查询列表
     */
    @Test
    public void getGroupSelectByNativeSql(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        IdentityService identityService = processEngine.getIdentityService();
        // 使用原生数据查询
        List<Group> list = identityService.createNativeGroupQuery().sql("select * from act_id_group where name_= #{name}").parameter("name","group_2").list();
        for (Group group :
                list) {
            log.info("group name is {}",group.getName());
        }
    }

    /**
     * 获得部署流程文件  可供下载使用
     * @throws Exception
     */
    @Test
    public void getDeployFile() throws Exception{
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //存储服务
        RepositoryService repositoryService = processEngine.getRepositoryService();
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment().addClasspathResource("bpmn/first.bpmn");
        deploymentBuilder.disableSchemaValidation();//关闭验证格式是否正确
        deploymentBuilder.disableBpmnValidation();//关闭验证流程是否正确
        Deployment deployment = deploymentBuilder.deploy();
        String deploymentId = deployment.getId();
//        InputStream inputStream = repositoryService.getResourceAsStream(deploymentId, "bpmn/first.bpmn");
        InputStream inputStream = repositoryService.getProcessModel(deploymentId);
        int length = inputStream.available();
        byte[] content = new byte[length];
        inputStream.read(content);
        String s = new String(content);
        log.info("bpmn content is {}",s);
    }

    /**
     * 获得流程部署图
     * @throws Exception
     */
    @Test
    public void getDeployFileImage() throws Exception{
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //存储服务
        RepositoryService repositoryService = processEngine.getRepositoryService();
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment().addClasspathResource("bpmn/first.bpmn");
        deploymentBuilder.disableSchemaValidation();//关闭验证格式是否正确
        deploymentBuilder.disableBpmnValidation();//关闭验证流程是否正确
        Deployment deployment = deploymentBuilder.deploy();
        String deploymentId = deployment.getId();
//        InputStream inputStream = repositoryService.getResourceAsStream(deploymentId, "bpmn/first.bpmn");
        InputStream inputStream = repositoryService.getProcessDiagram(deploymentId);
        BufferedImage image  = ImageIO.read(inputStream);
        File file = new File("resource/first.png");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ImageIO.write(image,"png",fileOutputStream);
        fileOutputStream.close();
        inputStream.close();

    }

    /**
     *  挂起流程
     * @throws Exception
     */
    @Test
    public void testSuspend() throws Exception{
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //存储服务
        RepositoryService repositoryService = processEngine.getRepositoryService();
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment().addClasspathResource("bpmn/first.bpmn");
        deploymentBuilder.disableSchemaValidation();//关闭验证格式是否正确
        deploymentBuilder.disableBpmnValidation();//关闭验证流程是否正确
        Deployment deployment = deploymentBuilder.deploy();
        String deploymentId = deployment.getId();
        //找到流程定义
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deploymentId).singleResult();
        //终止流程定义
        repositoryService.suspendProcessDefinitionById(processDefinition.getId());


        //如果重新启动 则会报错
        RuntimeService runtimeService = processEngine.getRuntimeService();
        runtimeService.startProcessInstanceByKey(processDefinition.getKey());

    }
    /**
     *  激活流程
     * @throws Exception
     */
    @Test
    public void testActivate() throws Exception{
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //存储服务
        RepositoryService repositoryService = processEngine.getRepositoryService();
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment().addClasspathResource("bpmn/first.bpmn");
        deploymentBuilder.disableSchemaValidation();//关闭验证格式是否正确
        deploymentBuilder.disableBpmnValidation();//关闭验证流程是否正确
        Deployment deployment = deploymentBuilder.deploy();
        String deploymentId = deployment.getId();
        //找到流程定义
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deploymentId).singleResult();
        //激活流程定义
        repositoryService.activateProcessDefinitionById(processDefinition.getId());

        //如果重新启动 则会没有问题
        RuntimeService runtimeService = processEngine.getRuntimeService();
        runtimeService.startProcessInstanceByKey(processDefinition.getKey());

    }

    /**
     * 查询该组 该用户的流程
     * @throws Exception
     */
    @Test
    public void testAuth() throws Exception{
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //存储服务
        RepositoryService repositoryService = processEngine.getRepositoryService();
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment().addClasspathResource("bpmn/first.bpmn");
        deploymentBuilder.disableSchemaValidation();//关闭验证格式是否正确
        deploymentBuilder.disableBpmnValidation();//关闭验证流程是否正确
        Deployment deployment = deploymentBuilder.deploy();
        String deploymentId = deployment.getId();
        //找到流程定义
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deploymentId).singleResult();

        IdentityService identityService = processEngine.getIdentityService();
        User user =identityService.newUser(UUID.randomUUID().toString());
        user.setFirstName("test_user_");
        identityService.saveUser(user);

        //将流程定义 分配给指定用户，只有该用户才能启动该流程.说明 addCandidateStarterGroup 指定给默认用户组，可在act_ru_identitylink表中看到关联关系
        repositoryService.addCandidateStarterUser(processDefinition.getId(),user.getId());

        //查找出该用户 所拥有的流程权限
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().startableByUser(user.getId()).list();

    }


    /**
     *  设置任务参数
     * @throws Exception
     */
    @Test
    public void testTask() throws Exception {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        //不推荐这样使用 ，这样就会与流程定义脱节，这里仅测试task故如此
        Task task = taskService.newTask(UUID.randomUUID().toString());
        task.setName("测试任务1");
        taskService.saveTask(task);


        //参数也分全局参数 跟 本地参数。如果传对象 则对象实现序列化，对应的获取getVariable获得参数，在bpmn中也可以直接设置参数。
        taskService.setVariable(task.getId(),"param","参数1");
    }


    /**
     * 获得部署信息列表
     */
    @Test
    public void getDeploymentList(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        List<Deployment> deploymentList = repositoryService.createDeploymentQuery().list();
        System.out.println("deploymentList size -----"+deploymentList.size());
    }

    @Test
    public void getModel(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Model model = repositoryService.getModel("5003");
        System.out.println("model  :" );
//        System.out.println("model size -----"+model.getId());
    }

    /**
     * 获得所有流程定义列表 可根据部署名称 查找出对应的流程定义列表
     */
    @Test
    public void getProcessDefinitionListList(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //根据部署名称获得所有部署ids
        String deploymentName ="";
        List<Deployment> deploymentList = repositoryService.createDeploymentQuery().deploymentNameLike("%"+deploymentName+"%").list();
        Set<String> deploymentIds = deploymentList.stream().map(Deployment::getId).collect(Collectors.toSet());

        //查找相关部署ids的流程定义列表  latestVersion限定了最新版本
        List<ProcessDefinition> processDefinitionList = repositoryService.createProcessDefinitionQuery().deploymentIds(deploymentIds).latestVersion().list();
        System.out.println("processDefinitionList size -----"+processDefinitionList.size());
    }

    /**
     * 将流程定义转成流程模型
     */
    public void convertToModel() throws UnsupportedEncodingException, XMLStreamException {
        //流程定义id：从getProcessDefinitionListList获得对应id
        String processDefinitionId="";
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId).singleResult();
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

    }
}
