package com.xander.designpattern.strcturetype.flyweight;

/**
 * Created by zhaobing04 on 2019/10/23.
 *
 * 具体享元类的超类或接口，通过这个接口，Flyweight可以接受并作用于外部状态。
 *
 * 内部状态指对象共享出来的信息，存储在享元对象内部并且不会随环境的改变而改变；
 * 外部状态指对象得以依赖的一个标记，是随环境改变而改变的、不可共享的状态。
 */
public abstract class Flyweight {

    //内部对象
    private String intrinsic;

    public String getExtrinsic() {
        return extrinsic;
    }

    public void setExtrinsic(String extrinsic) {
        this.extrinsic = extrinsic;
    }

    //外部对象
    private String extrinsic;

    //要求享元角色必须接收外部状态
    public Flyweight(String extrinsic){
        this.extrinsic = extrinsic;
    }

    public abstract void operation(int extrinsic);

    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }
}
