package com.hellojava.rule.spel;

import com.hellojava.rule.RuleEngine;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @ description: SpelRuleEngine
 * @ author: Liu Ran
 * @ data: 1/4/23 10:13
 */


public class SpelRuleEngine implements RuleEngine {

    private final Map<String, Expression> expressionMap = new HashMap<>();

    @Override
    public boolean match(String expr, Object obj) {
        Expression expression = getExpression(expr);
        EvaluationContext context = new StandardEvaluationContext(obj);
        Object result = expression.getValue(context);

        return result instanceof Boolean && (boolean) result;
    }

    private Expression getExpression(String expr) {
        Expression expression = expressionMap.get(expr);
        if (Objects.isNull(expression)) {
            ExpressionParser parser = new SpelExpressionParser();
            expression = parser.parseExpression(expr);
            expressionMap.put(expr, expression);
        }
        return expression;
    }




}
