package com.lura.helloreactor;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

import java.util.Arrays;

public class ReactorApp {

    static Logger logger = LoggerFactory.getLogger(ReactorApp.class);


    public static Mono<Void>  check() {
        return Mono.empty();
    }

    @SneakyThrows
    public static void main(String[] args) {



//        testFluxOnErrorContinue();
//        testFluxLimitRate();
        testFluxMonoVoid();

//        testContext();

        Thread.sleep(10000);

    }



    private static void testContext() {
        Mono.just("Hello")
                .map(lt -> {
                     Mono.subscriberContext()
                            .map(ctx -> lt +  ctx.get("KEY"))
                            .subscribe(System.out::println);
                    return lt;

                })
                .subscriberContext(Context.of("KEY", "World"))
                .subscribe(System.out::println);
    }

    private static void testFluxOnErrorContinue() {
        Flux.just(1, 2, 3, 4)
                    .doOnNext(ReactorApp::doSomeThing)
//                .onErrorContinue((e, object) -> System.out.println("---" + object))
                            .subscribe(System.out::println);
    }

    private static void testFluxMonoVoid() {
        Flux.range(1, 10)
                .flatMap(ReactorApp::doSomeThing2)
                .onErrorContinue((e, value) -> logger.warn(String.format("--%s", value), e))
                .doOnNext(i -> logger.info("success, {}", i))
                .doOnComplete(() -> logger.info("completed"))
                .subscribe();
    }

//    private static void testFluxLimitRate() {
//        Flux.range(1, Integer.MAX_VALUE)
//                .log()
//                .subscribeOn(Schedulers.parallel())
//                .onBackpressureBuffer()
//            .limitRate(1)
//                .doOnNext(i -> System.out.println(i))
//                .doOnNext(i -> {throw new RuntimeException(i + "");})
//                .onErrorContinue((e, o) -> System.out.println(e))
//                .doOnError(e -> System.out.println("error"))
//                .blockLast();
//    }

    private static void doSomeThing(int index) {
        if (index == 2) {
            throw new RuntimeException();
        }
    }

    private static Mono<Void> doSomeThing2(int index) {
//        if (index == 2) {
//            throw new RuntimeException();
//        }

        return Mono.empty();
    }


}
