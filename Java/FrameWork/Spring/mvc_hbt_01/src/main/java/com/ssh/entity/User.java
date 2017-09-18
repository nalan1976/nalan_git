package com.ssh.entity;

import lombok.Data;


import javax.persistence.*;

@Data
@Table
@Entity
public class User {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column
    private String username;
    @Column
    private String password;
}
