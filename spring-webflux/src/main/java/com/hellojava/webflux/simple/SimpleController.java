package com.hellojava.webflux.simple;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * SimpleController
 *
 * @author Liu Ran
 */
@RestController
@RequestMapping("simple")
public class SimpleController {

    @GetMapping("success")
    public Mono<String> success() {
        return Mono.justOrEmpty("success");
    }

}
