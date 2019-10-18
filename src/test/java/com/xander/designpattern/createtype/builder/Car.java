package com.xander.designpattern.createtype.builder;

/**
 * Created by zhaobing04 on 2019/10/17.
 */
public class Car {
    private String lunzi;
    private String fadongji;
    private String cheti;

    public Car(){
    }

    /**
     * 提供具体功能
     */
    public void run(){
        System.out.println("时速200运行");
    }


    public static final class Builder{
        private Car car;

        /**
         * 构建对象 开始
         */
        private String lunzi;
        private String fadongji;
        private String cheti;
        public Builder(){
            car = new Car();
        }

        public Builder setLunzi(){
            car.lunzi = "201";
            return this;
        }

        public Builder setFadongji(){
            car.fadongji = "GT909";
            return this;
        }

        public Builder setCheti(){
            car.cheti = "cheti";
            return this;
        }


        /**
         * 获取构建的对象
         * @return
         */
        public Car getCar(){
            return car;
        }
    }
}
