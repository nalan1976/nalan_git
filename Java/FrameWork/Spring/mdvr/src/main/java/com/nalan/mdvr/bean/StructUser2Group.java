package com.nalan.mdvr.bean;

import com.nalan.mdvr.entity.User;
import com.nalan.mdvr.entity.UserGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
//@EqualsAndHashCode(callSuper=true)
public class StructUser2Group implements Serializable{
    List<UserGroup> userGroupList = new ArrayList();
    Set<User> userList = new HashSet<>();//命名不太准确，应该是Set
}
