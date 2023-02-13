package com.hellojava.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.Transformer;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;
import org.springframework.aop.support.MethodMatchers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static net.bytebuddy.matcher.ElementMatchers.isInterface;
import static net.bytebuddy.matcher.ElementMatchers.isStatic;
import static net.bytebuddy.matcher.ElementMatchers.nameStartsWith;
import static net.bytebuddy.matcher.ElementMatchers.not;

/**
 * @ description: TODO
 * @ author: Liu Ran
 * @ data: 10/30/22 16:29
 */
public class StringByteBuddyApp {
    public static void main(String[] args) throws Exception {
//        byteBuddy1();
//        byteBuddy2();

        timeInterceptor();

    }

    private static void timeInterceptor() throws InstantiationException, IllegalAccessException {
        ByteBuddyAgent.install();
        AgentBuilder agentBuilder = new AgentBuilder.Default()
                .type(nameStartsWith("com.codecraft.demo")
                        .and(not(isInterface()))
                        .and(not(isStatic())))
                        .transform((builder,typeDescription,classLoader, module) -> builder
                                .method(ElementMatchers.any())
                                .intercept(MethodDelegation.to(TimeInterceptor.class)
                                ));
        agentBuilder.installOnByteBuddyAgent();


        System.out.println(Bar.sayHello());
    }

    private static void byteBuddy2() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> type = new ByteBuddy()
                .subclass(Object.class)
                .name("className")
                .defineMethod("custom", String.class, Modifier.PUBLIC)
                .intercept(MethodDelegation.to(Bar.class))
                .defineField("x", String.class, Modifier.PUBLIC)
                .make()
                .load(StringByteBuddyApp.class.getClassLoader())
                .getLoaded();

        Method method = type.getDeclaredMethod("custom", Object.class);
        Object ret = method.invoke(type.newInstance());
        System.out.println(ret);
        System.out.println(type.getDeclaredField("x"));

    }

    private static void byteBuddy1() throws InstantiationException, IllegalAccessException {
        DynamicType.Unloaded<Object> unloaded = new ByteBuddy()
                .subclass(Object.class)
                .method(ElementMatchers.isToString())
                .intercept(FixedValue.value(1))
                .make();

        Class<?> dynamicType = unloaded.load(StringByteBuddyApp.class.getClassLoader())
                                       .getLoaded();

        Object obj = dynamicType.newInstance();
        System.out.println(obj.hashCode());
        System.out.println(obj);
    }

}
