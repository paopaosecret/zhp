package com.xander.designpattern.createtype.builder;

/**
 * Created by zhaobing04 on 2019/10/17.
 */
public class CarClient {
    Car car = new Car.Builder().setCheti()
            .setFadongji()
            .setLunzi()
            .getCar();

    public void run() {
        car.run();
    }

    public static void main(String[] args) {
        CarClient carClient = new CarClient();
        carClient.run();
    }
}
