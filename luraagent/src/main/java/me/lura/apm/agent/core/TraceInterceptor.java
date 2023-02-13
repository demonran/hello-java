package me.lura.apm.agent.core;

import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.util.concurrent.Callable;

/**
 * @ description: TODO
 * @ author: Liu Ran
 * @ data: 10/30/22 20:07
 */
public class TraceInterceptor {

    @RuntimeType
    public static Object intercept(@SuperCall Callable<?> callable) throws Exception {
        System.out.println("trace");
        return callable.call();
    }
}
