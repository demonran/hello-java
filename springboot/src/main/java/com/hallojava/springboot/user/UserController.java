package com.hallojava.springboot.user;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@EnableBinding(Source.class)
@RequestMapping("users")
public class UserController {

    private final UserAppService userAppService;
    private final UserRepository userRepository;

    private final ApplicationEventPublisher eventPublisher;

    private final Source source;

    @GetMapping
    public List<User> list() {
       return userAppService.list();
    }


    @PostMapping
    public void create(@RequestBody User user) {
        userAppService.create(user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        eventPublisher.publishEvent(id);
    }


    @PutMapping("username")
    public void updateUsername(@RequestBody User resource) throws InterruptedException {
        User user = userRepository.findById(resource.getId()).orElse(null);
        user.setUsername(resource.getUsername());
        Thread.sleep(10000);
        User save = userRepository.save(user);
        System.out.println(save);
    }

    @PutMapping("password")
    public void updatePassword(@RequestBody User resource) {
        User user = userRepository.findById(resource.getId()).orElse(null);
        user.setPassword(resource.getPassword());
        userRepository.save(user);
    }

}
