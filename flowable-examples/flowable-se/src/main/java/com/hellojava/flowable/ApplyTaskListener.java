package com.hellojava.flowable;

import com.hellojava.flowable.task.CompleteTask;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.ExecutionListener;

import java.util.HashMap;

/**
 * ApplyTaskListener
 *
 * @author Liu Ran
 */
public class ApplyTaskListener implements ExecutionListener {
    @Override
    public void notify(DelegateExecution execution) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("reject", 0);//拒绝人数
        map.put("agree", 0);//同意人数
        execution.setVariables(map);

    }
}
