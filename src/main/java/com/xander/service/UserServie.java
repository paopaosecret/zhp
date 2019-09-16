package com.xander.service;

import com.xander.entity.User;

import java.util.List;

/**
 * Created by zhaobing04 on 2019/9/2.
 */
public interface UserServie {

    //显示所有用户
    public List<User> getUser()throws Exception;
    //根据id删除用户
    public void deleteUser(int id)throws Exception;
    //新增用户
    public void addUser(User user)throws Exception;
}
