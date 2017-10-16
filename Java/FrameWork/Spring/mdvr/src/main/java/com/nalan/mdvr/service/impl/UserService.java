package com.nalan.mdvr.service.impl;

import com.nalan.mdvr.bean.StructUser;
import com.nalan.mdvr.entity.User;
import com.nalan.mdvr.repository.IUserDao;
import com.nalan.mdvr.service.IUserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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
    public boolean checkUser(String username, String password) {
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
//        return userDao.hasUser(user);
        return userDao.checkLoginInfo(user);
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
}
