package com.xander.designpattern.createtype.prototype;

import com.alibaba.fastjson.JSON;

/**
 * Created by zhaobing04 on 2019/10/17.
 */
public class CircleShenClone implements Cloneable{
    private int r = 1;

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
        CircleShenClone circleShenClone = null;
        try {
            circleShenClone = (CircleShenClone)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        circleShenClone.setDot((Dot) dot.clone());
        return circleShenClone;
    }


    public static void main(String[] args) {
        CircleShenClone circle = new CircleShenClone();
        circle.setDot(new Dot(0,0));
        System.out.println(" circle dot:" + JSON.toJSONString(circle));

        CircleShenClone circle1 = (CircleShenClone) circle.clone();
        circle1.getDot().setX(2);
        circle1.setR(2);

        System.out.println(" circle dot:" + JSON.toJSONString(circle));
        System.out.println(" circle1 dot:" + JSON.toJSONString(circle1));
    }
}
