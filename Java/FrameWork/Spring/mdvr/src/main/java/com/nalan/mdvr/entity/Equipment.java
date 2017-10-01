/***********************************************************************
 * Module:  Equipment.java
 * Author:  Administrator
 * Purpose: Defines the Class Equipment
 ***********************************************************************/
package com.nalan.mdvr.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @pdOid a128a49d-d286-4bad-abd7-e5d4f1ea6a4d
 */
@Entity
@Table(name = "t_equipment")
@Data
public class Equipment extends BaseEntity {
    /**
     * @pdOid c571a589-7b26-4264-ab0d-fa0fbc6f269a
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer equipmentId;
    /**
     * @pdOid 7f2c951e-89e6-4acd-8b16-cc777054114d
     */
    private String equipmentName;
    /**
     * @pdOid 1ad4d366-18d4-49f1-b65e-bfb82c90d938
     */
    private String equipmentDescription;
    /**
     * @pdOid 886495b0-1f44-4046-a92e-e17e2f8c4d35
     */
    private String plateNumber;
    /**
     * @pdOid 8c605bfe-fb4b-42d2-b762-70d2e62fadca
     */
    private String ip;
    /**
     * @pdOid 3627c04a-3d4b-487c-a9cb-a5eb5383eef7
     */
    private String port;
    /**
     * @pdOid 0d6dd2a0-959e-4309-8929-d46686e8d363
     */
    private String gateway;
    /**
     * @pdOid 401b6272-e537-473e-bbad-e15e4188f26b
     */
    private Boolean needUpgrade;
    /**
     * @pdOid f1740837-4775-41b4-b057-2b54bfac6030
     */
    private Boolean needUpdateStrategy;
    /**
     * @pdOid 29448718-f2e0-46c8-a9be-1fc93b2009a1
     */
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "equipments")
    private Set<EquipGroup> equipGroups = new HashSet<>();

}