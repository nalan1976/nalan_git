package com.ssh.entity;

import lombok.Data;


import javax.persistence.*;

/**
 *
 *     编写java实体Bean时，都要养成几个习惯：
 _实现Serializable接口；
 _覆盖hashCode()和equals(Object obj)方法；
 _不再用基本类型定义字段；
 _定义了常用字段的构造方法时，一定要定义一个空的构造方法。
 * */

@Data
@Table
@Entity
public class User {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    //在已存在违规数据的情况下，会怎样？
    /**建表方式已经改为了create，但nullable=false仍没有起作用；数据库日志显示not null，但实际插入空数据仍成功
     * */
    @Column(nullable=false,length=100)
    private String username;
    @Column
    private String password;
}
