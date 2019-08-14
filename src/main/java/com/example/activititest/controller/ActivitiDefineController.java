package com.example.activititest.controller;

import com.example.activititest.base.ResultDTO;
import com.example.activititest.exception.GenericException;
import com.example.activititest.service.ActivitiDefineService;
import com.example.activititest.utils.ResultUtils;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * ActivitiDefineController
 * 流程定义相关controller
 */
@RestController
@RequestMapping("define")
public class ActivitiDefineController   {
    @Autowired
    private ActivitiDefineService activitiDefineService;

    /**
     * 分页查询
     *
     * @param params 查询参数
     * @return ResultDTO
     */
    @RequestMapping("/list")
    public ResultDTO list(@RequestParam Map<String, Object> params) {
        List list = activitiDefineService.queryPage(params);
        return ResultUtils.getSuccess(list);
    }

    /**
     * 读取资源，通过部署ID
     *
     * @param id       流程定义ID
     * @param proInsId 流程实例ID
     * @param resType  资源类型(xml|image)
     * @param response 响应
     * @throws Exception 读写流异常
     */
    @RequestMapping("/read")
    public void resourceRead(String id, String proInsId, String resType,
                             HttpServletResponse response)
            throws Exception {
        InputStream resourceAsStream = activitiDefineService.resourceRead(id, proInsId, resType);
        byte[] b = new byte[1024];
        int len = -1;
        int lenEnd = 1024;
        while ((len = resourceAsStream.read(b, 0, lenEnd)) != -1) {
            response.getOutputStream().write(b, 0, len);
        }
    }

    /**
     * 部署流程文件
     *
     * @param file file
     * @return ResultDTO
     */
    @RequestMapping("/deploy")
    public ResultDTO deploy(MultipartFile file) {
        String exportDir = this.getClass().getResource("/").getPath();
        String fileName = file.getOriginalFilename();
        String msg = "";
        if (StringUtils.isBlank(fileName)) {
            throw new GenericException("请选择要部署的流程文件");
        } else {
            try {
                msg = activitiDefineService.deploy(exportDir, file);
            } catch (Exception e) {
                return ResultUtils.getFail(e.getMessage());
            }
        }
        return ResultUtils.getSuccess( msg);
    }

    /**
     * 转为模型
     *
     * @param id id
     * @return ResultDTO
     */
    @RequestMapping("/convertToModel")
    public ResultDTO convertToModel(String id) {
        try {
            activitiDefineService.convertToModel(id);
        } catch (Exception e) {
            return ResultUtils.getFail(e.getMessage());
        }
        return ResultUtils.getSuccess(null);
    }
    /**
     * 查看流程图
     *
     * @param id 部署id
     * @return ResultDTO
     */
    @RequestMapping("/viewProcessImage")
    public ResultDTO viewProcessImage(String id,HttpServletResponse response) {
        try {
            activitiDefineService.viewProcessImage(id,response);
        } catch (Exception e) {
            return ResultUtils.getFail(e.getMessage());
        }
        return ResultUtils.getSuccess(null);
    }

    /**
     * 启动流程实例，通过processDefinitionId
     *
     * @param processDefinitionId processDefinitionId
     * @param assignee 发起人
     * @return ResultDTO
     */
    @RequestMapping("/startProcessInstanceById")
    public ResultDTO startProcessInstanceById(String processDefinitionId,String assignee) {
        try {
            activitiDefineService.startProcessInstanceById(processDefinitionId,assignee);
        } catch (Exception e) {
            return ResultUtils.getFail(e.getMessage());
        }
        return ResultUtils.getSuccess(null);
    }

    /**
     * 激活 / 挂起
     *
     * @param state
     * @param id
     * @return
     */
    @RequestMapping("/update")
    public ResultDTO update(int state, String id) {
        String msg = activitiDefineService.updateState(state, id);
        return ResultUtils.getSuccess( msg);
    }

    /**
     * 删除部署的流程，级联删除流程实例
     *
     * @param deploymentId 流程部署标识
     * @return ResultDTO
     */
    @RequestMapping("/delete")
    public ResultDTO delete(@RequestBody String[] deploymentId) {
        activitiDefineService.deleteBatch(deploymentId);
        return ResultUtils.getSuccess(null);
    }



}
