package com.xander.designpattern.strcturetype.adapter;

/**
 * Created by zhaobing04 on 2019/10/18.
 */
public class Data {
    private String name;
    private String icon;

    public Data(String name, String icon){
        this.name = name;
        this.icon = icon;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
