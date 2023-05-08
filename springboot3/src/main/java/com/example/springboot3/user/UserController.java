package com.example.springboot3.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @ description: UserController
 * @ author: Liu Ran
 * @ data: 5/6/23 14:02
 */

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/")
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping("name")
    public Optional<User> byName() {
        return userRepository.findByName("aaa");
    }

    @GetMapping("{id}")
    public Optional<User> byId(@PathVariable Long id) {
        return userRepository.findById(id);
    }

}
