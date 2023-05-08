package com.example.springboot3.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @ description: UserRepository
 * @ author: Liu Ran
 * @ data: 5/6/23 13:45
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String name);

}
