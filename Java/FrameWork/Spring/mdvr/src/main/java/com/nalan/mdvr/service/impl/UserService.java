package com.nalan.mdvr.service.impl;

import com.nalan.mdvr.bean.StructMenu;
import com.nalan.mdvr.bean.StructUser;
import com.nalan.mdvr.entity.User;
import com.nalan.mdvr.repository.IUserDao;
import com.nalan.mdvr.service.IUserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

//import com.nalan.mdvr.repository.impl.BaseDao;
//import com.nalan.mdvr.repository.impl.UserDao;

@Data
@Service
@Scope("prototype")
@Transactional
public class UserService implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        return userDao.checkLoginInfo(user);
/*        if(userDao.checkLoginInfo(user) != null){
            return user;
        }
        return null;*/
    }

    @Override
//    public StructUser addUser(StructUser userStruct){
//        userDao.save(userStruct.getUser());
//        return userStruct;
//    }
    public StructUser addUser(String userName, int userType, String pswd) {
        User user = new User();
        user.setUserName(userName);
        user.setUserType(userType);
        user.setPassword(pswd);
        user.setCreateDatetime(new Date());
        userDao.save(user);

        StructUser structUser = new StructUser();
        if (user.getUserId() > 0) {
            structUser = new StructUser();
            structUser.setUser(user);
        }
        userDao.flush();
        //返回当前所有用户
        List<User > list =  userDao.findAllByHql(user);
        if(list.size() != 0) {
            for (User u : list) {
                structUser.setUserInfo(u.getUserId(), u.getUserName(), u.getUserType(), u.getCreateDatetime());
            }
            return structUser;
        }
        return null;
    }
    public List<User> delUser(Map<String, Integer> userIdInfo){
        for(Map.Entry<String, Integer> entry : userIdInfo.entrySet()){
            userDao.deleteById(entry.getValue());
        }
        userDao.flush();
        User user = new User();
        List<User > list =  userDao.findAllByHql(user);//这里只是要一个类型
        if(list.size() != 0)
            return list;

        return null;
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
    public StructMenu getMenu(){

        List set = new ArrayList();
        Map<Integer, String> map = new TreeMap<>();
        map.put(1, "setup/userGroup");
        map.put(101, "setup/userGroup");
        set.add(map);

        Map<Integer, String> map2 = new TreeMap<>();
        map2.put(2, "reporting");
        set.add(map2);

        StructMenu menu = new StructMenu();
        menu.setMenuList(set);
        return menu;
    }
}
