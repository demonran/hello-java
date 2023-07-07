package com.hallojava.springboot.user;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ description: UserCreatedEvent
 * @ author: Liu Ran
 * @ data: 6/27/23 13:05
 */
@Data
@AllArgsConstructor
public class UserCreatedEvent {
    private User user;
}
