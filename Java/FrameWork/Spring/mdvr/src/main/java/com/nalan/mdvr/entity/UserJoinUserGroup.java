//package com.nalan.mdvr.entity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
/**
 * 本文件没有被包含，但代码是正确的，能够生成联合主键，只是没有外键对应
 * 将联合主键的字段单独放在一个类中，该类需要实现java.io.Serializable接口并要重写equals和hashcode.
 * 最后在主类中(该类包含联合主键类中的字段)将联合主键字段都注解为@Id,并在该类上方将上这样的注解：@IdClass(联合主键类.class)
 * */
@Data
@Entity
@Table(name = "t_user_join_usergroup")
@IdClass(MiddleClass.class)//nalan_*:联合主键:*;
public class UserJoinUserGroup {
    @Id
    private Integer userId;
    @Id
    private Integer userGroupId;
}

class MiddleClass implements Serializable{
    private static final long serialVersionUID = 842348868051226105L;
    private Integer userId;
    private Integer userGroupId;

    @Override
    public boolean equals(Object obj){//nalan_*:equals:*;    Java核心技术第七版162页
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;

        MiddleClass other = (MiddleClass)obj;
        return userId == other.userId
            && userGroupId == other.userGroupId;
    }
    @Override
    public int hashCode(){//nalan_*:hashCode:*;
        return 13*userId.hashCode()+31*userGroupId.hashCode();
    }
}
