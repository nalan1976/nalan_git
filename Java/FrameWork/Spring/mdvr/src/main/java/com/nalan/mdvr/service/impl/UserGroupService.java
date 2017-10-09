package com.nalan.mdvr.service.impl;

import com.nalan.mdvr.bean.StructUserGroup;
import com.nalan.mdvr.entity.UserGroup;
import com.nalan.mdvr.repository.IUserGroupDao;
import com.nalan.mdvr.service.IUserGroupService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Data
@Service
@Scope("prototype")
@Transactional
public class UserGroupService implements IUserGroupService{
    @Autowired
    private IUserGroupDao userGroupDao;
//    private StructUserGroup structUserGroup = new StructUserGroup();

    public StructUserGroup addUserGroup(String userGroupName){
        StructUserGroup structUserGroup = new StructUserGroup();
        structUserGroup.userGroup = userGroupDao.addUserGroup(userGroupName);

        if(structUserGroup.userGroup != null) {
            userGroupDao.flush();
            List<UserGroup> ls = userGroupDao.findAllByHql();
            //装填数据准备返回状态及完整数据：应包含添加的对象完整信息+返回列表有效信息
//            for(UserGroup ug : ls)
//                structUserGroup.setInfo(ug.getUserGroupId(), ug.getUserGroupName());

            for(int i = 0; i < ls.size(); i++){//nalan_*:list:iterate:*;    上面的遍历方法也可以
                structUserGroup.setInfo(ls.get(i).getUserGroupId(), ls.get(i).getUserGroupName());
            }
            return structUserGroup;
        }
        return null;
    }
}
