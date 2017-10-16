/***********************************************************************
 * Module:  EquipGroup.java
 * Author:  Administrator
 * Purpose: Defines the Class EquipGroup
 ***********************************************************************/
package com.nalan.mdvr.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_equip_group")
@EqualsAndHashCode(callSuper=true)
@Data
/** @pdOid e664afe2-967d-4957-9a4d-50921493d8c4 */
public class EquipGroup extends BaseEntity {
    /**
     * @pdOid 6a1b4088-7241-4549-b7ad-ea1f3b1889d6
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer equipGroupId;
    /**
     * @pdOid a295ac20-e616-49e1-975b-ebd097db0db0
     */
    private String equipGroupName;
    /**
     * @pdOid 28b49a63-88cf-4e7e-acf1-eb5e00de55cb
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "t_equip_join_equipgroup",
    joinColumns = @JoinColumn(name = "equipGroupId"), inverseJoinColumns = @JoinColumn(name = "equipmentId"))
    private Set<Equipment> equipments = new HashSet<>();
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "t_user_join_equipgroup",
            joinColumns = @JoinColumn(name = "equipGroupId"), inverseJoinColumns = @JoinColumn(name = "userId"))
    private Set<User> users = new HashSet<>();

}