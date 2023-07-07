package com.hallojava.springboot.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    public List<User> list() {
        return userRepository.findAllByDeleted(false);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
