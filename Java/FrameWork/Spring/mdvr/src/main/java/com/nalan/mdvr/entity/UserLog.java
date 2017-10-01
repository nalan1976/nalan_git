/***********************************************************************
 * Module:  UserLog.java
 * Author:  Administrator
 * Purpose: Defines the Class UserLog
 ***********************************************************************/
package com.nalan.mdvr.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @pdOid 694a4097-928a-4ac1-90ad-de1f667ce060
 */
@Data
@Table(name = "t_user_log")
@Entity
public class UserLog extends BaseEntity {
    /**
     * @pdOid 23377a74-dec5-45d9-bb71-71de3e2f140d
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer logId;
    /**
     * @pdOid 267c974d-4d53-458f-b658-0a7c4324e2d3
     */
    private String lastLoginIp;
    /**
     * @pdOid 2480785e-29a1-4f35-bf33-2593b329aaa0
     */
    private String lastLoginDatetime;
    /**
     * @pdOid 4c3e1d8b-e09b-45cb-814b-42e04ecd2745
     */
    @ManyToOne//nalan_*:@ManyToOne:单向:*;
    @JoinColumn(name = "userId")//对方主键作为自己的外键，对方不知道自己的存在
    private User user;

}