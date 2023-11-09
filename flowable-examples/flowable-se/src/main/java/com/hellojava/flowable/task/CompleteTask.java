package com.hellojava.flowable.task;

import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.DelegateExecution;

/**
 * ComplateTask
 *
 * @author Liu Ran
 */


@Slf4j
public class CompleteTask {

    public boolean compleTaskTo(DelegateExecution execution){
        log.info("任务会签总数："+execution.getVariable("nrOfInstances"));
        log.info("待会签任务数量："+execution.getVariable("nrOfActiveInstances"));
        log.info("已完成会签任务数量："+execution.getVariable("nrOfCompletedInstances"));
//设置权重
        Integer agree = (Integer) execution.getVariable("agree");//同意人数
        if(agree/(Integer) execution.getVariable("nrOfInstances")>0.5){
            log.info("同意人数："+agree);
            //设置会签结果 排他网关会用到
            execution.setVariable("status","true");
            return  true;
        }else{
            return  false;
        }
    }
}
