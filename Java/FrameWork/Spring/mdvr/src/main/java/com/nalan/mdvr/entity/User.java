/***********************************************************************
 * Module:  UserDao.java
 * Author:  Administrator
 * Purpose: Defines the Class User
 ***********************************************************************/
package com.nalan.mdvr.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.*;

/** userType：
 *   0：普通用户
 *   1：超级用户admin
 * @pdOid b61eb705-e3fe-4307-8431-1a2bf357c6b7 */
//@Data
@EqualsAndHashCode(callSuper=true)
@Table(name = "t_user")
@Entity
public class User extends BaseEntity {
   /** @pdOid 1ccf11d1-8064-4509-9f42-64cfd1b3df75 */
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer userId;
   /** @pdOid 8afed723-7b39-4e8a-8b6f-e488ba127948 */
//   @Column(name = "username")
   private String userName;
   /** @pdOid c5f60446-d1d8-4abf-855f-dd2eb62a3571 */
//   @Column(name = "usertype")
   private Integer userType = 0;
   /** @pdOid ca1d5678-23be-4035-b280-08753af79a9f */
   private String password;
   /** @pdOid dc0af8d8-065d-4d94-a03f-7b22d5027997 */
   private java.util.Date createDatetime;
   /** @pdOid b07aead3-d466-4ff3-bdb7-841415085b64 */
//   @Transient
   @ManyToMany(mappedBy = "users", cascade = CascadeType.MERGE)//nalan_*:@ManyToMany:*;
   @JsonIgnore//nalan_*:json:convert:*;   解决与userGroup互相引用，导致系列化为json时，递归出错的问题
   private Set <UserGroup> userGroups = new HashSet<>();
   /** @pdOid 5542e560-845e-4a80-a25a-0af4c453404e */
//   @Transient
//   @ManyToMany(cascade = CascadeType.ALL)
//   @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
   @ManyToMany(cascade = CascadeType.MERGE)
   @JoinTable(name = "t_user_join_authority", joinColumns = @JoinColumn(name = "userId"),
      inverseJoinColumns = @JoinColumn(name = "authorityId"))//nalan_*:?:*;   写成别的会否有问题？不会有问题！
   private Set <Authority> userAuthoritys = new HashSet<>();
   /** @pdOid edc2d93d-311a-4ce3-a022-1f7c4af8bd80 */
//   @Transient
   @ManyToMany(mappedBy = "equipments", cascade = CascadeType.MERGE)
   private Set <EquipGroup> equipGroups = new HashSet<>();

   public void setUserId(Integer userId) {
      this.userId = userId;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public void setUserType(Integer userType) {
      this.userType = userType;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public void setCreateDatetime(Date createDatetime) {
      this.createDatetime = createDatetime;
   }

   public void setUserGroups(Set<UserGroup> userGroups) {
      this.userGroups = userGroups;
   }

   public void setUserAuthoritys(Set<Authority> userAuthoritys) {
      this.userAuthoritys = userAuthoritys;
   }

   public void setEquipGroups(Set<EquipGroup> equipGroups) {
      this.equipGroups = equipGroups;
   }

   public Integer getUserId() {

      return userId;
   }

   public String getUserName() {
      return userName;
   }

   public Integer getUserType() {
      return userType;
   }

   public String getPassword() {
      return password;
   }

   public Date getCreateDatetime() {
      return createDatetime;
   }

   public Set<UserGroup> getUserGroups() {
      return userGroups;
   }

   public Set<Authority> getUserAuthoritys() {
      return userAuthoritys;
   }

   public Set<EquipGroup> getEquipGroups() {
      return equipGroups;
   }
}