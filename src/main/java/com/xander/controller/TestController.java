package com.xander.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhaobing04 on 2019/8/24.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @ResponseBody     //
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "this is JsonData";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
