package com.nalan.mdvr.bean;

import com.nalan.mdvr.entity.UserGroup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StructUserGroup implements Serializable{
    private static final long serialVersionUID = -5714539466835003200L;

    class InnerUserGroup{
        private int userGroupId;

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

        private String userGroupName;
    }

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

    public StructUserGroup() {
        innerUserGroups = new ArrayList<InnerUserGroup>();
    }

    public List<InnerUserGroup> innerUserGroups;
//    private InnerUserGroup obj = new InnerUserGroup();
    public UserGroup userGroup;

    public void setInfo(final int id, final String name){
        InnerUserGroup obj = new InnerUserGroup();
        obj.userGroupId = id;
        obj.userGroupName = name;
        this.innerUserGroups.add(obj);
    }
}
