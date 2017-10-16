package com.nalan.mdvr.bean;

import com.nalan.mdvr.entity.UserGroup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//用于转化输出到前台userGroup表中的数据到json对象
public class StructUserGroup implements Serializable{
    private static final long serialVersionUID = -5714539466835003200L;

    class InnerUserGroup{
        private int userGroupId;
        private String userGroupName;
//自动生成
        public int getUserGroupId() {
            return userGroupId;
        }

        public void setUserGroupId(int userGroupId) {
            this.userGroupId = userGroupId;
        }

        public void setUserGroupName(String userGroupName) {
            this.userGroupName = userGroupName;
        }

        public String getUserGroupName() {
            return userGroupName;
        }
//自动生成end
    }
    //自动生成
    public void setInnerUserGroups(List<InnerUserGroup> innerUserGroups) {
        this.innerUserGroups = innerUserGroups;
    }

    public List<InnerUserGroup> getInnerUserGroups() {
        return innerUserGroups;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }
    //自动生成end

    public StructUserGroup() {
        innerUserGroups = new ArrayList<InnerUserGroup>();
    }

    public List<InnerUserGroup> innerUserGroups;

    public UserGroup userGroup;

    public void setInfo(final int id, final String name){
        InnerUserGroup obj = new InnerUserGroup();
        obj.userGroupId = id;
        obj.userGroupName = name;
        this.innerUserGroups.add(obj);
    }
}
