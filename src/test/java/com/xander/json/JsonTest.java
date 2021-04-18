package com.xander.json;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaobing04 on 2019/8/28.
 */
public class JsonTest {
    public static void main(String args[]){
        testMap();
//        testList();
    }

    public static void testMap(){
        Map<String, String> map = new HashMap<>();
        map.put("id","123");
        map.put("name", "lisi");

        String str = JSON.toJSONString(map);
        Map<String, String> parseMap = (Map<String, String>) JSON.parse(str);
        System.out.println(parseMap.get("id"));
        System.out.println(parseMap.get("name"));
    }

    public static void testList(){
        String jsonStr = "[{\"ask\":\"1\",\"answer\":\"2\"}]";
        ArrayList<SymboltemBean> list = (ArrayList<SymboltemBean>) JSON.parseArray(jsonStr, SymboltemBean.class);
        System.out.println(JSON.toJSONString(list));
    }

    public class SymboltemBean implements Serializable {
        private String ask;
        private String answer;


        public String getAsk() {
            return ask;
        }

        public void setAsk(String ask) {
            this.ask = ask;
        }

        public String getAnswer() {
            return answer;
        }


    }
}
