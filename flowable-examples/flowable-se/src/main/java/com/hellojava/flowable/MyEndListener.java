package com.hellojava.flowable;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.ExecutionListener;

import java.util.HashMap;

/**
 * MyEndListener
 *
 * @author Liu Ran
 */
public class MyEndListener implements ExecutionListener {
    @Override
    public void notify(DelegateExecution execution) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", true);//同意人数
        execution.setVariables(map);
    }
}
