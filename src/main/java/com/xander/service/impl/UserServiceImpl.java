package com.xander.service.impl;

import com.alibaba.fastjson.JSON;
import com.xander.entity.User;
import com.xander.mapper.UserMapper;
import com.xander.service.UserServie;
import com.xander.utils.RedisUtil;
import com.xander.utils.StringUtils;
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


    private static final String REDIS_KEY_USER_LIST = "redis_key_user_list";

    @Override
    public List<User> getUser() throws Exception {
        String jsonStr = RedisUtil.getJedis().get(REDIS_KEY_USER_LIST);
        if(StringUtils.isEmpty(jsonStr)){
            System.out.println("返回从db");
            List<User> userList = userMapper.getUser();
            RedisUtil.getJedis().set(REDIS_KEY_USER_LIST, JSON.toJSONString(userList));
            return userList;
        }else{
            List<User> userList = JSON.parseArray(jsonStr, User.class);
            System.out.println("返回从redis");
            return userList;
        }


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
