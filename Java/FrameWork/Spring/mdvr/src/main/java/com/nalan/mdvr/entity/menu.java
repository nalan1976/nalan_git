package com.nalan.mdvr.entity;


import lombok.Data;


import javax.persistence.*;
//import javax.persistence.GeneratedValue;


@Data
@Entity
@Table(name = "t_menu")
public class menu {
/*    @Id
    @Column(length = 32, nullable = false)
    @GeneratedValue(generator = "system-uuid")//配置uuid，本来jpa是不支持uuid的，但借用hibernate的方法可以实现。
    @GenericGenerator(name = "system-uuid", strategy="org.hibernate.id.UUIDGenerator")*/

/*    @GeneratedValue( generator = "uuid" )
    @GenericGenerator(
            name = "uuid",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )*/
@Id
//@GeneratedValue
@Column(nullable = false)
/*业务上确实不适合用uuid做主键
@GeneratedValue(generator = "uuid")
@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")//nalan_*:uuid::*;
@Column(length = 32, nullable = false)
//@Column(name = "id", columnDefinition = "BINARY(16)" , unique = true)*/
    private Integer menuId;
    private String menuName;
    private String url;
    private Integer fatherId;

}
