package com.hallojava.springboot.asyncweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;

/**
 * AsyncController
 * 异步调用接口类
 * @author Liu Ran
 */

@RestController
@RequestMapping("async")
public class AsyncController {

    @GetMapping("callable")
    public Callable<String> callable() {
        return () -> {
            System.out.println(Thread.currentThread().getName());
            return "success";
        };
    }

    @GetMapping("webAsyncTask")
    public WebAsyncTask<String> webAsyncTask() {
        WebAsyncTask<String> webAsyncTask = new WebAsyncTask<>(3000, () -> "webAsyncTask");
        webAsyncTask.onTimeout(() -> "timeout");
        return webAsyncTask;
    }
}
