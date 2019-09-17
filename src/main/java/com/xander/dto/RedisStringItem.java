package com.xander.dto;

/**
 * Created by zhaobing04 on 2019/9/17.
 */
public class RedisStringItem {
    private String key;
    private int seconds;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return "key:"+key+", value="+value+", seconds:"+seconds;
    }
}
