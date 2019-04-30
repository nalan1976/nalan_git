package com.ssh.entity;

import lombok.Data;
//import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;



@Data
@Entity
@Table(name = "Person")
//@Cache 定义了二级缓存策略和缓存范围，好像没有加入相关jar包依赖
//@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
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