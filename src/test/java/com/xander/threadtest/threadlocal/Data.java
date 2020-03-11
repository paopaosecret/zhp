package com.xander.threadtest.threadlocal;

/**
 * Created by zhaobing04 on 2019/12/27.
 */
public class Data {
    private int id;
    private String name;

    public Data(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " id = " + getId() + ", name = " + getName();
    }
}
