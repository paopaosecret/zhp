package com.xander.controller;

import com.xander.dto.RedisStringItem;
import com.xander.utils.RedisUtil;
import com.xander.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhaobing04 on 2019/9/17.
 */
@Controller
@RequestMapping("/redis")
public class RedisController {

    /**
     * 请求设置参数方式1：设置基本类型和String
     * get请求：@RequestParam(name = "name") String name
     * @param key
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public String delete(@RequestParam(name = "key") String key){
        try {
            RedisUtil.getJedis().del(key);
            return "从redis中删除key 成功";
        }catch (Exception e){
            e.printStackTrace();
            return "从redis中删除key 失败";
        }
    }

    /**
     * 请求设置参数方式2：设置对象类型
     * @param item
     * @return
     */
    @ResponseBody
    @PostMapping("/set")
    public String set(RedisStringItem item){
        try {
            if(item != null){
                System.out.println(item.toString());
                RedisUtil.getJedis().setex(item.getKey(), item.getSeconds(), item.getValue());
                return "添加key 成功";
            }else{
                return "参数异常，删除失败！！！";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "添加key 失败";
        }
    }

    @ResponseBody
    @GetMapping("/get")
    public String get(String key){
        try {
            System.out.println("请求参数key : " + key);
            String value = RedisUtil.getJedis().get(key);
            if(StringUtils.isEmpty(value)){
                return "获取key 成功，  为空";
            }else{
                return value;
            }
        }catch (Exception e){
            e.printStackTrace();
            return "获取key 失败";
        }
    }
}
