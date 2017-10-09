/***********************************************************************
 * Module:  UserGroup.java
 * Author:  Administrator
 * Purpose: Defines the Class UserGroup
 ***********************************************************************/
package com.nalan.mdvr.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
/**
 * 在单向关系中没有mappedBy,主控方相当于拥有指向另一方的外键的一方。
 1.一对一和多对一的@JoinColumn注解的都是在“主控方”，都是本表指向外表的外键名称。
 2.一对多的@JoinColumn注解在“被控方”，即一的一方，指的是外表中指向本表的外键名称。
 3.多对多中，joinColumns写的都是本表在中间表的外键名称， inverseJoinColumns写的是另一个表在中间表的外键名称。//nalan_*:@ManyToMany:*;
 * */
/**
 * @pdOid 50479195-415e-4ebc-9bac-e7114b709579
 */
//@Data
@Entity
@Table(name = "t_user_group")
public class UserGroup extends BaseEntity {
    /**
     * @pdOid 12699285-8724-47d6-8596-fbe5b9f8e768
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userGroupId;

    public void setUserGroupId(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    public void setUserGroupName(String userGroupName) {
        this.userGroupName = userGroupName;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void setUserGroupAuthoritys(Set<Authority> userGroupAuthoritys) {
        this.userGroupAuthoritys = userGroupAuthoritys;
    }

    public Integer getUserGroupId() {

        return userGroupId;
    }

    public String getUserGroupName() {
        return userGroupName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Set<Authority> getUserGroupAuthoritys() {
        return userGroupAuthoritys;
    }

    /**
     * @pdOid 713f8de7-2ba7-49db-ab59-b94b3d02a4b7
     */

    private String userGroupName;
    /**
     * @pdOid 75fbebaa-dc9a-4812-938f-01f2f2878dc2
     */
//   @Transient
    @ManyToMany(cascade = CascadeType.ALL)//nalan_*:@ManyToMany:*;
//    多对多中，joinColumns写的都是本表在中间表的外键名称， inverseJoinColumns写的是另一个表的主键在中间表的外键名称
    @JoinTable(name = "t_user_join_usergroup",
            joinColumns = @JoinColumn(name = "userGroupId"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    private Set<User> users = new HashSet<>();
    /**
     * @pdOid 36634b01-4064-44b1-9024-149cf3f0beea
     */
//    @Transient
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "t_usergroup_join_authority",
            joinColumns = @JoinColumn(name = "userGroupId"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private Set<Authority> userGroupAuthoritys = new HashSet<>();
//   @OneToMany(mappedBy = "userGroups", fetch = FetchType.LAZY)
//   private List <UserJoinUserGroup> userJoinUserGroup;

}