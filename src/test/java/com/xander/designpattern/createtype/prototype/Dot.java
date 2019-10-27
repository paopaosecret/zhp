package com.xander.designpattern.createtype.prototype;

/**
 * Created by zhaobing04 on 2019/10/17.
 */
public class Dot implements Cloneable{
    private int x;
    private int y;

    public Dot(){}

    public Dot(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
