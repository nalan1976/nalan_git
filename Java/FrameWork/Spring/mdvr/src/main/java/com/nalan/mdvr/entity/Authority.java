/***********************************************************************
 * Module:  Authority.java
 * Author:  Administrator
 * Purpose: Defines the Class Authority
 ***********************************************************************/
package com.nalan.mdvr.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * type：
 * 0：menu
 * 1：function
 *
 * @pdOid 7ec60de7-a772-431a-98f6-02d829365a25
 */
@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name = "t_authority")
public class Authority extends BaseEntity {
    /**
     * @pdOid 95a4e16e-7d70-4b4c-8870-f8df87dee94d
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * @pdOid d44f3746-abd0-4cce-813f-13fbc3048e75
     */
    private String name;
    /**
     * @pdOid 4eae8bac-d457-4d04-a5d4-137cfb5b2c19
     */
    private Integer type;
    @ManyToMany(mappedBy = "userAuthoritys", cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<>();
    @ManyToMany(mappedBy = "userGroupAuthoritys", cascade = CascadeType.ALL)
    private Set<UserGroup> userGroups = new HashSet<>();

}