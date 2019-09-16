package com.xander.controller;

import com.alibaba.fastjson.JSON;
import com.xander.pojo.User;
import com.xander.service.UserServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhaobing04 on 2019/9/16.
 */
@Controller
@RequestMapping("/user")    //给Controller指定 路径
public class UserController {

    @Autowired
    private UserServie userService;

    @Autowired
    private User user;

    @ResponseBody     //如果使用此注解：返回的数据不匹配模板，不使用则匹配模板
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "this is JsonData";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    //显示用户
    @ResponseBody  // //如果使用此注解：返回的数据不匹配模板，不使用则匹配模板
    @RequestMapping("/list")
    public List<User> list() throws Exception {
        return userService.getUser();
    }
    //删除用户
    @ResponseBody
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id) throws Exception {
        userService.deleteUser(id);
        return "你已经删掉了id为"+id+"的用户";
    }
    //增加用户
    @ResponseBody
    @RequestMapping("/addUser")
    public String addUser() throws Exception {
        user.setPassword("123456");
        user.setName("zhangsan");
        userService.addUser(user);
        return JSON.toJSONString(user);
    }


}
