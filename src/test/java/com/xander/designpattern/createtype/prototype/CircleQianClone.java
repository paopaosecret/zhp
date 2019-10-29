package com.xander.designpattern.createtype.prototype;

/**
 * Created by zhaobing04 on 2019/9/30.
 */
public class CircleQianClone implements Cloneable {

    private int r;

    private Dot dot;

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public Dot getDot() {
        return dot;
    }

    public void setDot(Dot dot) {
        this.dot = dot;
    }

    /**
     * Object 类的方法
     * @return
     */
    @Override
    public Object clone(){
        try {
            return (CircleQianClone)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
