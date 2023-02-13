package com.hellojava.rule.spel;

import com.google.common.collect.ImmutableList;
import com.hellojava.rule.Flight;
import com.hellojava.rule.Order;
import com.hellojava.rule.Rule;
import com.hellojava.rule.RuleEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @ description: SpelRuleEngineJmhTest
 * @ author: Liu Ran
 * @ data: 1/5/23 09:48
 */

@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
@Fork(1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
public class SpelRuleEngineJmhTest {

    private final RuleEngine ruleEngine = new SpelRuleEngine();
    private  final static Flight flight;
    private final static String expr;

    static {
        flight = getFlight();
        List<Rule> rules = getRule();
        expr = rules.stream().map(Rule::getExpr).collect(Collectors.joining(" && "));
        System.out.println(expr);
    }

//    @Benchmark
    public void match() {
        Order order = getOrder();
        IntStream.range(0, 10000).forEach(i -> ruleEngine.match("(price> 1 && count > 11) && status == \"PAID\" && deleted == false && product.name.contains(\"乒\")",
                order));
    }

        @Benchmark
    public void oneTimeTest() {
        Order order = getOrder();
        ruleEngine.match("(price> 1 && count > 101) || status == \"PAID\" && deleted == false && product.name.contains(\"乒\")",
                order);
    }

    /**

     */
    @Test
    @Benchmark
    public void test_flight_air_steps_car_case1() {

        boolean match = ruleEngine.match(expr, flight);
        Assertions.assertTrue(match);
    }



    /**
     *   * 客梯车（同时满足）：
     *      * 1. 远机位： F.stand.type
     *      * 2. 排除某些机位： !("201","301").contains(F.stand.code)
     *      * 3. ["W/Z","A/B"].contains(F.task)
     *      * 4. ["3A","CA"].contains.(F.airline.code)
     *      * 5. ["过站","航前"].anyMatch(F.tags)
     *      * 6. F.过站时长> 10 && F.过站时长 < 50
     *      *  排除机位个数： 30
     *      *  飞行任务个数：10
     *      *  航空公司： 50
     *      *  匹配标签： 30， 航班标签：20
     *      */
    private static List<Rule> getRule() {
        //2. 排除某些机位： !("201","301").contains(F.stand.code)
        List<String> excludeStands = getRandomStands(30);
        String excludeStandStrs = excludeStands.stream().map(str -> "'" + str + "'").collect(Collectors.joining(",", "{", "}"));
        // 3. ["W/Z","A/B"].contains(F.task)
        List<String> tasks = getRandomTasks(9);
        tasks.add("W/Z");
        String taskStrs = tasks.stream().map(str -> "'" + str + "'").collect(Collectors.joining(",","{","}"));
        //4. ["3A","CA"].contains.(F.airline.code)
        List<String> airlineCodes = getRandomAirline(49);
        airlineCodes.add("CA");
        String airlineCodeStrs = airlineCodes.stream().map(str -> "'" + str + "'").collect(Collectors.joining(",", "{", "}"));
        // 5. ["过站","航前"].anyMatch(F.tags)
        List<String> tags = getRandomTags(29);
        tags.add("川航");
        String tagStrs = tags.stream().map(str -> "'" + str + "'").collect(Collectors.joining(",", "{", "}"));


        return ImmutableList.of(
                Rule.of("stand.type == 'REMOTE'"),
                Rule.of("!" + excludeStandStrs + ".contains(stand.code)"),
                Rule.of(taskStrs + ".contains(task)"),
                Rule.of(airlineCodeStrs + ".contains(airline.code)"),
                Rule.of("tagContains("+ tagStrs +")"),
                Rule.of("standingTime > 10 && standingTime < 50")
        );
    }

    private Order getOrder() {
        return new Order().setPrice(2).setCount(100).setStatus("PAID").setDeleted(false).setProduct(new Order.Product().setName("乒乓球"));
    }

    private static Flight  getFlight() {
        List<String> tags = getRandomTags(19);
        tags.add("川航");
         return Flight.builder()
                 .airline(Flight.Airline.of("CA"))
                 .standingTime(30)
                 .task("W/Z")
                 .tags(tags)
                 .stand(Flight.Stand.of("REMOTE", "301"))
                 .build();
    }


    private static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        length = length == -1 ? random.nextInt(19) + 1 : length;
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, length).forEach(i -> sb.append(str.charAt(random.nextInt(str.length() -1))));
        return sb.toString();

    }

    private static List<String> getRandomTasks(int count) {
        return IntStream.range(0, count).mapToObj(i -> getRandomString(3).toUpperCase()).collect(Collectors.toList());
    }

    private static List<String> getRandomAirline(int count) {
        return IntStream.range(0, count).mapToObj(i -> getRandomString(2).toUpperCase()).collect(Collectors.toList());

    }

    private static List<String> getRandomTags(int count) {
        return IntStream.range(0, count).mapToObj(i -> getRandomString(-1).toUpperCase()).collect(Collectors.toList());
    }

    private static List<String> getRandomStands(int count) {
        return IntStream.range(0, count).mapToObj(i -> getRandomString(3).toUpperCase()).collect(Collectors.toList());
    }

    @Test
    public void test_get_random_string() {
        List<String> stands = getRandomStands(30);
        System.out.println(stands);
    }

    public static void main(String[] args) throws RunnerException {
        System.out.println(Objects.equals(null, null));
        Options opt = new OptionsBuilder()
                .include(SpelRuleEngineJmhTest.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }
}
