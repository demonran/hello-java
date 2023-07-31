package com.hallojava.springboot.user;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.persistence.EntityManager;
import java.util.Arrays;
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

    public void create(User user) {
        user.setUsername("admin");
        Role role = new Role();
        role.setName("管理员");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);

    }

    public void updateRoles(Long id, List<Role> roles) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not exist"));
        user.getRoles().clear();
        user.getRoles().addAll(roles);
        userRepository.save(user);
    }
}
