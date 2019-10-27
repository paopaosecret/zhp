package com.xander.designpattern.strcturetype.proxy.staticproxy;

/**
 * Created by zhaobing04 on 2019/10/18.
 */
public class RealRequest implements IRequest {
    @Override
    public void request() {
        System.out.println("网络请求执行");
    }
}
