package com.xander.service.impl;

import com.xander.mapper.UserMapper;
import com.xander.pojo.User;
import com.xander.service.UserServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhaobing04 on 2019/9/16.
 */
@Service
public class UserServiceImpl implements UserServie{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUser() throws Exception {
        return userMapper.getUser();
    }

    @Override
    public void deleteUser(int id) throws Exception {
        userMapper.deleteUser(id);
    }

    @Override
    public void addUser(User user) throws Exception {
        userMapper.addUser(user);
    }
}
