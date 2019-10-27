package com.xander.designpattern.strcturetype.proxy.staticproxy;

/**
 * Created by zhaobing04 on 2019/10/18.
 */
public class RequestProxy implements IRequest {

    private IRequest realRequest;

    public RequestProxy(){
        if(realRequest == null){
            realRequest = new RealRequest();
        }
    }

    private void before(){
        System.out.println("请求即将执行");
    }

    private void end(){
        System.out.println("请求执行结束");
    }


    @Override
    public void request() {
        before();
        realRequest.request();
        end();
    }
}
