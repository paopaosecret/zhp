package com.xander.designpattern.strcturetype.flyweight;

/**
 * Created by zhaobing04 on 2019/10/23.
 *
 * 具体享元类的超类或接口，通过这个接口，Flyweight可以接受并作用于外部状态。
 *
 * 内部状态指对象共享出来的信息，存储在享元对象内部并且不会随环境的改变而改变；例如棋子的颜色
 * 外部状态指对象得以依赖的一个标记，是随环境改变而改变的、不可共享的状态。例如棋子的位置
 */
public abstract class Flyweight {

    //内部对象：不会随环境的改变而改变，同一个享元对象其内部状态是一致的，例如棋子的颜色，
    private String intrinsic;

    //外部对象：随环境的改变而改变，例如棋子的位置
    private String extrinsic;

    public Flyweight(String intrinsic){
        this.intrinsic = intrinsic;
    }

    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }

    public String getExtrinsic() {
        return extrinsic;
    }

    public void setExtrinsic(String extrinsic) {
        this.extrinsic = extrinsic;
    }

    public abstract void operation(int extrinsic);


}
