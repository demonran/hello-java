package com.hallojava.springboot;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@EnableBinding(Source.class)
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    private final Source source;

    @GetMapping
    public List<User> list() {
        Message<UserEvent> message = MessageBuilder.withPayload(new UserEvent("test")).build();
        source.output().send(message);
       return userService.list();
    }

}
