package com.hallojava.springboot;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.provider.certpath.IndexedCollectionCertStore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    private final UserRepository userRepository;

    @Transactional
    public String hello() {
        User user  = new User();
        user.setUsername("test");
        eventPublisher.publishEvent(new UserEvent(user));
//        throw new RuntimeException();
        return "hello";
    }

    public List<User> list() {
        return userRepository.findAllByDeleted(false);
    }
}
