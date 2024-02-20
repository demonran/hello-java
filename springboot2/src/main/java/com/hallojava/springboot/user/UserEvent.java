package com.hallojava.springboot.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.ApplicationEvent;


@Data
@AllArgsConstructor
public class UserEvent  {

   private String username;
}
