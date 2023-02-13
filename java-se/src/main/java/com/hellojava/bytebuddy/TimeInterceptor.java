package com.hellojava.bytebuddy;

import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.util.concurrent.Callable;

/**
 * @ description: TODO
 * @ author: Liu Ran
 * @ data: 10/30/22 18:32
 */
public class TimeInterceptor {
    @RuntimeType
    public static Object intercept(@SuperCall Callable<?> callable) throws Throwable{
        System.out.println("intercept");
        return callable.call();
    }
}
