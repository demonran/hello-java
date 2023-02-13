package com.hellojava.rule.spel;

import com.hellojava.rule.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;


/**
 * @ description: SpelRuleEngineTest
 * @ author: Liu Ran
 * @ data: 1/4/23 13:30
 */
class SpelRuleEngineTest {

    private final SpelRuleEngine ruleEngine = new SpelRuleEngine();
    @Test
    void should_return_true_when_giving_expr_is_price_large_then_one_and_price_is_two() {
        boolean actual = ruleEngine.match("price > 1",
                new Order().setPrice(2)
        );
        Assertions.assertTrue(actual);
    }

    @Test
    void should_return_giving_complex_expr() {
        boolean actual = ruleEngine.match( "price> 1 && count > 11 && status == \"PAID\" && deleted == false && product.name.contains(\"乒\")",
                getOrder());

        Assertions.assertTrue(actual);
    }

    private Order getOrder() {
        return new Order().setPrice(2).setCount(100).setStatus("PAID").setDeleted(false).setProduct(new Order.Product().setName("乒乓球"));
    }


    @Test
    void benchmark_test_for_spel_rule_engine_match() throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SpelRuleEngine.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }

}
