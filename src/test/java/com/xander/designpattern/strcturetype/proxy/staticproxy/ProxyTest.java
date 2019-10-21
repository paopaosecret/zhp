package com.xander.designpattern.strcturetype.proxy.staticproxy;

/**
 * Created by zhaobing04 on 2019/10/18.
 */
public class ProxyTest {
    public static void main(String[] args) {
        IRequest request = new RequestProxy();
        request.request();
    }
}
