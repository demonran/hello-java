package com.hallojava.springboot;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("user")
public class User {
    @Id
    private Long id;
    private String username;
    private Boolean deleted;
}