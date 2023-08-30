package com.hellojava.flowable;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.common.impl.AbstractEngineConfiguration;
import org.flowable.engine.impl.cfg.StandaloneInMemProcessEngineConfiguration;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.flowable.task.api.TaskQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 请假主类
 *
 * @author Liu Ran
 */
public class HolidayRequest {
    public static void main(String[] args) {
        ProcessEngineConfiguration cfg = new StandaloneInMemProcessEngineConfiguration();
//        cfg.setJdbcUrl("jdbc:mysql://192.168.1.110:3306/flowable?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false&createDatabaseIfNotExist=true");
//        cfg.setJdbcUsername("osrcloud");
//        cfg.setJdbcPassword("osrcloud_sit_password");
//        cfg.setJdbcDriver("com.mysql.cj.jdbc.Driver");
//        cfg.setDatabaseSchemaUpdate(AbstractEngineConfiguration.DB_SCHEMA_UPDATE_CREATE_DROP);
        cfg.setDatabaseSchemaUpdate(AbstractEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine processEngine = cfg.buildProcessEngine();

        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("holiday-request.bpmn20.xml")
                .deploy();

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .deploymentId(deploy.getId())
                .singleResult();

        System.out.println("Found process definition : " + processDefinition.getName());

        RuntimeService runtimeService = processEngine.getRuntimeService();
        Map<String, Object> variable = new HashMap<>();
        variable.put("employee", "张三");
        // key 为xml中Process的ID
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holidayRequest", variable);

        System.out.println("流程实例ID：" + processInstance.getId());

        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("managers")
                .list();

        System.out.println("You have " + tasks.size() + " tasks:");
        for (int i=0; i<tasks.size(); i++) {
            System.out.println((i+1) + ") " + tasks.get(i).getName());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("选择任务来完成?");
        Task task = tasks.get(Integer.valueOf(scanner.nextLine()) - 1);
        Map<String, Object> variables = taskService.getVariables(task.getId());
        System.out.println(variables.get("employee") + " 的请假申请");

        System.out.println("处理(y/n)");
        String approveCmd = scanner.nextLine();
        boolean approved = approveCmd.toUpperCase().equals("Y");
        variables.put("approved", approved);
        taskService.complete(task.getId(), variables);
    }
}
