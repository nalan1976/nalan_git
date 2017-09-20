package com.ssh.entity;
/**
 * 注意：
 * 1）大文件存取应该试一下
 * */
import lombok.Data;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;

@Data
@Entity
@Table
public class UserPaging {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String password;

//    @Temporal(TemporalType.TIMESTAMP)//nalan
    private Date datetime;

    @Lob
    @Basic(fetch=FetchType.LAZY)
    @Column(name="photo", columnDefinition="BLOB")
    private Blob photo;

}
