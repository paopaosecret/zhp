package com.xander.designpattern.behaviortype.dutychain;

/**
 * Created by zhaobing04 on 2018/3/17.
 * 责任链（Chain of Responsibility）模式：
 * 为了避免请求发送者与多个请求处理者耦合在一起，将所有请求的处理者通过前一对象记住其下一个
 * 对象的引用而连成一条链；当有请求发生时，可将请求沿着这条链传递，直到有对象处理它为止。
 *
 * 抽象处理者（Handler）角色：->Handler 定义一个处理请求的接口，包含抽象处理方法和一个后继连接。
 * 具体处理者（Concrete Handler）角色：实现抽象处理者的处理方法，判断能否处理本次请求，如果可以处理请求则处理，否则将该请求转给它的后继者。
 * 客户类（Client）角色：->Note 创建处理链，并向链头的具体处理者对象提交请求，它不关心处理细节和请求的传递过程。
 */

public class Note {

    public static void main(String[] args){
        int[] requests = {2,9,12,34,19,3,89};
        Handler h1 = new HandlerImp1();
        Handler h2 = new HandlerImp2();
        Handler h3 = new HandlerImp3();
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);

        for(int request:requests){
            h1.handlerRequest(request);
        }
    }
}
