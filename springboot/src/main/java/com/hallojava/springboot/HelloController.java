package com.hallojava.springboot;

import com.hallojava.springboot.user.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @Autowired
    private UserAppService userAppService;

    @RequestMapping("/")
    public String hello() {
       return userAppService.hello();
    }

}
