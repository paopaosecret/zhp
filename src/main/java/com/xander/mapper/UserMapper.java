package com.xander.mapper;

import com.xander.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhaobing04 on 2019/9/16.
 */
@Repository
@Mapper
public interface UserMapper {
    //获取用户名单
    List<User> getUser() throws Exception;

    //根据id删除用户
    void deleteUser(int id)throws Exception;

    //新增用户
    long addUser(User user)throws Exception;
}
