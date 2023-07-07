package com.hallojava.springboot.user;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserAppService {
    private final ApplicationContext eventPublisher;

    private final UserRepository userRepository;

    private final UserService userService;

    private final EntityManager em;

    @Transactional
    public String hello() {
        User user  = new User();
        user.setUsername("test");
        eventPublisher.publishEvent(new UserEvent("user"));
//        throw new RuntimeException();
        return "hello";
    }

    public List<User> list() {
        return userRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id) {
        userService.deleteById(id);
    }

    @Transactional
    public void create(User user) {
        user.setId(new Random().nextLong());
        User savedUser = userRepository.saveAndFlush(user); // 保存实体并立即刷新持久化上下文
        em.refresh(savedUser);
        System.out.println(savedUser.getSid()); // 获取自增列的值
    }
}
