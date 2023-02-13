package com.hellojava.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class CompletableFutureApp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /**
         * 1. CompletableFuture.complete后才会触发handleAsync
        **/
        CompletableFuture<String> future = new CompletableFuture<>();
        future
                .thenApply(c -> {
                    System.out.println(c);
                    return "aaaa";
                })
                .handleAsync((message, ex) -> {
            System.out.println(ex);
            System.out.println(message);
            return message;
        }, Executors.newCachedThreadPool());
        future.complete("sfa");

        System.out.println(future.get());

        String s = CompletableFuture.supplyAsync(() -> "message")
                                    .get();



        System.out.println(s);
    }
}
