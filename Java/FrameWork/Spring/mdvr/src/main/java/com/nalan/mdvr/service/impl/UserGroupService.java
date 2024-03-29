package com.nalan.mdvr.service.impl;

import com.nalan.mdvr.bean.PassInStruct;
import com.nalan.mdvr.bean.StructUser2Group;
import com.nalan.mdvr.bean.StructUserGroup;
import com.nalan.mdvr.entity.User;
import com.nalan.mdvr.entity.UserGroup;
import com.nalan.mdvr.repository.IUserDao;
import com.nalan.mdvr.repository.IUserGroupDao;
import com.nalan.mdvr.service.IUserGroupService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Data
@Service
@Scope("prototype")
@Transactional
public class UserGroupService implements IUserGroupService {
    @Autowired
    private IUserGroupDao userGroupDao;
    @Autowired
    private IUserDao userDao;
    //nalan_*:SQL:join:inner:*;
    private static final String QUERY_USERGROUP_BY_ID =
            "SELECT u.* FROM t_user u INNER JOIN t_user_join_usergroup ug ON u.userId = ug.userId WHERE ug.userGroupId = ?";
//    private static final String QUERY_USERGROUP_BY_ID ="SELECT userId FROM t_user_join_usergroup WHERE userGroupId = ?";

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
        if (ls.size() != 0)
            for (UserGroup ug : ls)
                structUserGroup.setInfo(ug.getUserGroupId(), ug.getUserGroupName());

        return structUserGroup;

    }

    private StructUserGroup getAll() {
        StructUserGroup structUserGroup = new StructUserGroup();
        List<UserGroup> ls = userGroupDao.findAllByHql();
        //装填数据准备返回状态及完整数据：应包含添加的对象完整信息+返回列表有效信息
//        if(ls != null)
        if (ls.size() != 0)
            for (UserGroup ug : ls)
                structUserGroup.setInfo(ug.getUserGroupId(), ug.getUserGroupName());

        return structUserGroup;

    }

    public StructUserGroup chgUserGroup(int userGroupId, String newName) {
        StructUserGroup structUserGroup = new StructUserGroup();
        //先根据id返回对象更改数据，再重新查询并返回所有结果
        structUserGroup.userGroup = (UserGroup) userGroupDao.get(userGroupId);//get 不到会返回什么？null?
        if (structUserGroup.getUserGroup() != null) {
            structUserGroup.getUserGroup().setUserGroupId(userGroupId);
            structUserGroup.getUserGroup().setUserGroupName(newName);
            userGroupDao.update(structUserGroup.getUserGroup());//session相关函数没有返回值，晕！
        }
        //是否需要flush？
        userGroupDao.flush();
        return getAll(structUserGroup);
//        return null;
    }

    public StructUser2Group addUser2Group(Map<String, Integer> mapInfo) {
        UserGroup userGroup = new UserGroup();
//        Set<User> user = new

//        UserDao userDao = new UserDao();

        for (String key : mapInfo.keySet()) {//nalan_*:JDK:map:iterate:*;
            //第一个参数是用户组id，将待加入的用户对象取出
            if (key.equals("0")) {
//                userGroup.setUserGroupId(mapInfo.get(key));
                userGroup = (UserGroup) userGroupDao.get(mapInfo.get(key));
            } else {//后面的参数都是待加入用户组的用户id，取出后依次获得对应的用户对象，并放入用户组对象中
                User user = new User();
//                user.setUserId(mapInfo.get(key));
                //用哪一个Dao去取用户对象？
                user = (User) userDao.get(mapInfo.get(key));
                userGroup.getUsers().add(user);//User对象必须实现hashCode和equals
            }
        }
//     保存用户组对象，此时中间表数据也应该保存
        userGroupDao.save(userGroup);
        userGroupDao.flush();
        StructUser2Group structUser2Group = new StructUser2Group();
        structUser2Group.setUserGroupList(userGroupDao.findAllByHql());
        structUser2Group.setUserList(userGroup.getUsers());

        return structUser2Group;
        /*
            for (String key : map.keySet()) {
                System.out.println(key + " ：" + map.get(key));
            }
            使用entrySet()遍历

            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " ：" + entry.getValue());
            }
        * */
    }

    public List<User> showUserGroup(Integer userGroupId) {
        //一条语句通过内关联得到用户组对应的所有用户
//        Object obj[] = null;
        List<User> userList = userGroupDao.getAllBySql(QUERY_USERGROUP_BY_ID, userGroupId);
//        userGroupDao.getAllBySql("select userId from t_user_join_usergroup where userGroupId = :userGroupId", userGroupId);
        return userList;
    }
}
