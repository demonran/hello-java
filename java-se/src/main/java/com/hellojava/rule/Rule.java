package com.hellojava.rule;

import lombok.Data;
import lombok.Value;

/**
 * @ description: Rule
 * @ author: Liu Ran
 * @ data: 1/5/23 09:37
 */
@Value(staticConstructor = "of")
public class Rule {
    String expr;
}
