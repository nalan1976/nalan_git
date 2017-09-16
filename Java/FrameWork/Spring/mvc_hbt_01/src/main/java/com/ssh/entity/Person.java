package com.ssh.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "Person")
public class Person {

    @Id
    //默认为：(strategy = GenerationType.AUTO)，会生成主键表，插入数据失败
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created")
    private Long created = System.currentTimeMillis();

    @Column(name = "username")
    private String username;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "remark")
    private String remark;
}