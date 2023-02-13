package me.lura.apm.agent.core;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

/**
 * @ description: TODO
 * @ author: Liu Ran
 * @ data: 10/30/22 18:25
 */
public class LuraAgent {

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("premain");
        new AgentBuilder.Default()
                .type(ElementMatchers.any())
                .transform(new AgentBuilder.Transformer() {
                    @Override
                    public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader) {
                        return builder.name(typeDescription.getName())
                                      .method(ElementMatchers.any())
                                      .intercept(MethodDelegation.to(TraceInterceptor.class));
                    }
                }).installOn(inst);
    }
}
