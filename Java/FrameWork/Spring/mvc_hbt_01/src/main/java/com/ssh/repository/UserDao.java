package com.ssh.repository;


import com.ssh.bean.Page;
import com.ssh.entity.UserPaging;


import java.util.List;

public interface UserDao {
    public abstract void save(UserPaging user);

    public abstract void update(UserPaging user);

    public abstract void delete(UserPaging user);

    public abstract UserPaging getUserPaging(Integer id);

    //数据分页
    public abstract List listAllUserPagings(Page page);
}
