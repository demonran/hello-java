package com.hellojava.rule;

/**
 * @ description: RuleEngine
 * @ author: Liu Ran
 * @ data: 1/4/23 09:24
 */
public interface RuleEngine {

    boolean match(String expr, Object obj);
}
