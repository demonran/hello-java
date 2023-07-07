package com.hallojava.springboot.user;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.Table;
import javax.persistence.Version;

@Data
@Entity
@Table(name = "user")
@DynamicUpdate
@Audited
public class User {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid")
    private Long sid;
    private String username;

    private String password;

    private Boolean deleted;



    @PostPersist
    private void afterPersist() {
        System.out.println(this.getSid()); // 获取自增列的值
    }
}
