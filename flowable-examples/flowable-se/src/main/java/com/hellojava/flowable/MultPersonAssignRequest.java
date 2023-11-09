package com.hellojava.flowable;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.common.impl.AbstractEngineConfiguration;
import org.flowable.engine.impl.cfg.StandaloneInMemProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.task.api.Task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MultPersonAssignRequest
 *
 * @author Liu Ran
 */
public class MultPersonAssignRequest {

    public static void main(String[] args) {
        ProcessEngineConfiguration cfg = new StandaloneInMemProcessEngineConfiguration();
        cfg.setJdbcUrl("jdbc:mysql://192.168.1.110:3306/flowable?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false&createDatabaseIfNotExist=true");
        cfg.setJdbcUsername("osrcloud");
        cfg.setJdbcPassword("osrcloud_sit_password");
        cfg.setJdbcDriver("com.mysql.cj.jdbc.Driver");
        cfg.setDatabaseSchemaUpdate(AbstractEngineConfiguration.DB_SCHEMA_UPDATE_CREATE_DROP);
        cfg.setDatabaseSchemaUpdate(AbstractEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine processEngine = cfg.buildProcessEngine();

        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("multi-person-assign.bpmn20.xml")
                .deploy();

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .deploymentId(deploy.getId())
                .singleResult();

        RuntimeService runtimeService = processEngine.getRuntimeService();
        //启动流程并分配给
        Map<String,Object> map = new HashMap<>();
        //注意这里的值必须大于 设置的基数
        map.put("persons", Arrays.asList("张三","李四","王二狗","赵天"));
        runtimeService.startProcessInstanceById(processDefinition.getId(), map);

        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().list();

        tasks.forEach(task -> System.out.println(Arrays.asList(task.getAssignee(), task.getId(), task.getDelegationState())));
        System.out.println(tasks);

        for (int i = 0; i < 2; i++) {
            Task task = tasks.get(i);
            Map<String,Object> map_task = new HashMap<>();
            Integer reject = (int)taskService.getVariable(task.getId(),"agree");
            map_task.put("agree",reject+1);

            taskService.complete(task.getId(), map_task);
        }

        tasks.forEach(task -> System.out.println(Arrays.asList(task.getAssignee(), task.getId(), task.getDelegationState())));



    }
}
