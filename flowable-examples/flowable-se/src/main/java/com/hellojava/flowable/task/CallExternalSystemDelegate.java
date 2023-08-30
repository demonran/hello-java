package com.hellojava.flowable.task;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * CallExternalSystemDelegate
 *
 * @author Liu Ran
 */
public class CallExternalSystemDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("调用外部接口");
    }
}
