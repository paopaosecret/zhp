package com.xander.controller;

import com.alibaba.fastjson.JSON;
import com.xander.entity.User;
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
 * @RequestMapping 注解添加路径
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServie userService;

    /**
     * Controller使用@Controller 注解， 默认返回模板页面 如：{@link UserController#hello()}
     * 当方法加了@ResponseBody 这个注解  则返回字符串 如：{@link UserController#index()}
     * @return
     */
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @ResponseBody
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "this is JsonData";
    }

    @ResponseBody  // //如果使用此注解：返回的数据不匹配模板，不使用则匹配模板
    @RequestMapping("/list")
    public List<User> list() throws Exception {
        return userService.getUser();
    }

    @ResponseBody
    @RequestMapping("/delete")
    public String delete(@PathVariable int id) throws Exception {
        userService.deleteUser(id);
        return "你已经删掉了id为"+id+"的用户";
    }

    @ResponseBody
    @RequestMapping("/addUser")
    public String addUser() throws Exception {
        User user = new User();
        user.setPassword("123456");
        user.setName("zhangsan");
        userService.addUser(user);
        return JSON.toJSONString(user);
    }

    @ResponseBody
    @RequestMapping("/clearRedis")
    public String clearRedis(@PathVariable String key) throws Exception {
        userService.delRedisByKey(key);
        return "从Redis中删除Key成功";
    }

}
