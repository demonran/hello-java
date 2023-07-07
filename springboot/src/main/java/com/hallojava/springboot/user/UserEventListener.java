package com.hallojava.springboot.user;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @ description: UserEventListener
 * @ author: Liu Ran
 * @ data: 2/14/23 15:53
 */

@Component
@RequiredArgsConstructor
public class UserEventListener {

    private final UserAppService userAppService;
    private final UserRepository userRepository;

    @TransactionalEventListener
    @Async
    public void onMessage(UserCreatedEvent event) {
        System.out.println(event);
        User user = userRepository.findAll().get(0);
        userAppService.deleteById(user.getId());

    }

}
