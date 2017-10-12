package com.nalan.mdvr.service.impl;

import com.nalan.mdvr.bean.PassInStruct;
import com.nalan.mdvr.bean.StructUserGroup;
import com.nalan.mdvr.entity.UserGroup;
import com.nalan.mdvr.repository.IUserGroupDao;
import com.nalan.mdvr.service.IUserGroupService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

@Data
@Service
@Scope("prototype")
@Transactional
public class UserGroupService implements IUserGroupService {
    @Autowired
    private IUserGroupDao userGroupDao;

    public StructUserGroup addUserGroup(String userGroupName) {
        StructUserGroup structUserGroup = new StructUserGroup();
        //添加用户组成功后返回必要的信息填充结构
        structUserGroup.userGroup = userGroupDao.addUserGroup(userGroupName);

        if (structUserGroup.userGroup != null) {
            userGroupDao.flush();
            return getAll(structUserGroup);
/*            List<UserGroup> ls = userGroupDao.findAllByHql();
            //装填数据准备返回状态及完整数据：应包含添加的对象完整信息+返回列表有效信息


            for (int i = 0; i < ls.size(); i++) {//nalan_*:list:iterate:*;
                structUserGroup.setInfo(ls.get(i).getUserGroupId(), ls.get(i).getUserGroupName());
            }
            return structUserGroup;*/
        }
        return null;
    }

    public StructUserGroup delUserGroup(List<PassInStruct> ugIdList) {
        Iterator<PassInStruct> it = ugIdList.iterator();
        while (it.hasNext()) {
            //测试是前台传过来的是字符串，要转数字
            userGroupDao.deleteById(Integer.parseInt(it.next().getUserGroupId()));//nalan_*:java:convert:*;
            //这里没有对输入是有有效、删除失败、找不到对应数据做出处理，真正做项目时，还应封装返回状态信息告知前台错误的类型及其它细节
        }
        //返回所有表中数据
        userGroupDao.flush();//使删除的数据入库并同步一级缓存
        return getAll();
    }

    //重载了带传入值的getAll
    private StructUserGroup getAll(StructUserGroup structUserGroup) {
//        StructUserGroup structUserGroup = new StructUserGroup();
        List<UserGroup> ls = userGroupDao.findAllByHql();
        //装填数据准备返回状态及完整数据：应包含添加的对象完整信息+返回列表有效信息
        if(ls.size() != 0)
            for (UserGroup ug : ls)
                structUserGroup.setInfo(ug.getUserGroupId(), ug.getUserGroupName());

        return structUserGroup;

    }
    private StructUserGroup getAll() {
        StructUserGroup structUserGroup = new StructUserGroup();
        List<UserGroup> ls = userGroupDao.findAllByHql();
        //装填数据准备返回状态及完整数据：应包含添加的对象完整信息+返回列表有效信息
//        if(ls != null)
        if(ls.size() != 0)
            for (UserGroup ug : ls)
                structUserGroup.setInfo(ug.getUserGroupId(), ug.getUserGroupName());

        return structUserGroup;

    }
    public StructUserGroup chgUserGroup(int userGroupId, String newName){
        StructUserGroup structUserGroup = new StructUserGroup();
        //先根据id返回对象更改数据，再重新查询并返回所有结果
        structUserGroup.userGroup = (UserGroup) userGroupDao.get(userGroupId);//get 不到会返回什么？null?
        if(structUserGroup.getUserGroup() != null){
            structUserGroup.getUserGroup().setUserGroupId(userGroupId);
            structUserGroup.getUserGroup().setUserGroupName(newName);
            userGroupDao.update(structUserGroup.getUserGroup());//session相关函数没有返回值，晕！
        }
        //是否需要flush？
        userGroupDao.flush();
        return getAll(structUserGroup);
//        return null;
    }
}
