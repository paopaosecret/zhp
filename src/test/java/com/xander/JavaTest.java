package com.xander;

import com.xander.javabase.annotation.Start;
import com.xander.utils.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static java.lang.Double.NaN;

/**
 * Created by zhaobing04 on 2019/8/28.
 */
public class JavaTest {
    Boolean boolean1;
    boolean boolean2;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("即将被销毁");
        super.finalize();
    }
    public static int testFinally() {
        int b = 20;

        try {
            System.out.println("try block");

            return b += 80;
        }
        catch (Exception e) {

            System.out.println("catch block");
        }
        finally {

            System.out.println("finally block");

            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }
            return 20;
        }
    }
    public static final Object object = new Object();
    public static void main(String args[]){
//        JavaTest test =  new JavaTest();
//        System.out.println(test.boolean1);
//        System.out.println(test.boolean2);
//        System.out.println("1/0 = " + 1/0 );
//        System.out.println("1/0 = " + 1.0/0 );
        int result = testFinally();
        System.out.println("result :" + result);
        System.out.println(0.01+0.05 == 0.06);
//        testLong();
//        List<Obj> list = new ArrayList<>();
//        for(int i= 1; i<= 20; i++){
//            Obj obj = new Obj(i);
//            list.add(obj);
//        }
//        Obj obj = new Obj(5);
//        if(list.contains(obj)){
//            list.remove(obj);
//            System.out.println("list中包含obj:size = " + list.size());
//        }
//
//        OpObj opObj = new OpObj(obj);
//        opObj.add();;
//        System.out.println("obj.a == " + obj.a + "    obj.b == " + obj.b);



    }



    public static void testJSON(){
////        ArrayList<SymboltemBean> symboltemBeans = new ArrayList<>();
////
////        SymboltemBean bean = new SymboltemBean();
////        bean.setSymbol("selfServiceMall");
////        bean.setJumpUrl("https://mshop.58.com/intelligentmarket/home/getHomeIndex?source=app_58sjt");
////        symboltemBeans.add(bean);
////
////        SymboltemBean bean1 = new SymboltemBean();
////        bean1.setSymbol("welfarehome");
////        bean1.setJumpUrl("https://mshop.58.com/intelligentmarket/home/getHomeIndex?source=app_58sjt");
////        symboltemBeans.add(bean1);
////
////        String jsnoStr = JSON.toJSONString(symboltemBeans);
////        System.out.println(jsnoStr);
//
//        ArrayList<SymboltemBean> list = (ArrayList<SymboltemBean>) JSON.parseArray(jsnoStr, SymboltemBean.class);
//        System.out.println(JSON.toJSONString(list));
    }

    public static void testLong(){
        long timestamp = 1559038439563L;
        long id = (timestamp<<8 + 254);
        System.out.println(id);
    }

    public static void testNull(){
        String string = "hello";
        if(!string.equals(null)){
            System.out.println("不是null");
        }else{
            System.out.println();
        }
    }

    static class OpObj{
        Obj obj;
        public OpObj( Obj obj){
            this.obj = obj;
        }

        public void add(){
            obj.a = 100;
            obj.b = 200;
        }
    }

    static class Obj{
        public Obj(int a){
            this.a = a;
        }

        int a = 10;
        int b = 10;

        @Override
        public boolean equals(Object obj) {
            return this.a == ((Obj)obj).a;
        }
    }


    /**
     * false 展示  true:不展示
     * @return
     * @throws Exception
     */
    @Test
    public void testMatch(){

        CPCAndGMVState state = new CPCAndGMVState();
        CountDownLatch latch = new CountDownLatch(2);
        new Thread(new Task(state, latch,  BusinessType.CPC)).start();
        new Thread(new Task(state, latch, BusinessType.GMV)).start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("state.gmvState:" + state.gmvState + "  state.cpcState:" + state.cpcState);

    }

    /**
     * 存储cpc 和 gmv接口返回状态
     */
    static class CPCAndGMVState{
        boolean cpcState = false;
        boolean gmvState = false;
    }

    static class Task implements Runnable {
        private CPCAndGMVState state;
        private CountDownLatch latch;
        private BusinessType type;
        public Task(CPCAndGMVState state,CountDownLatch countDownLatch,  BusinessType type){
            this.state = state;
            this.latch = countDownLatch;
            this.type = type;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread() + " is Run:" + type + System.currentTimeMillis());
                if(type == BusinessType.GMV){
                    Thread.sleep(2000);
                    if(true){
                        //CommonResult 格式：{"code":0,"data":false,"message":"SUCCESS"}
                        if(true){
                            state.gmvState =  true;
                        }
                    }
                }else if(type == BusinessType.CPC){
                    String result = "fd";
                    Thread.sleep(4000);
                    if(!StringUtils.isEmpty(result)){
                        state.cpcState =  true;
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                latch.countDown();
                System.out.println(Thread.currentThread() + " is Run end:" + type + System.currentTimeMillis());
            }
        }
    }

    static enum BusinessType{
        CPC,
        GMV,
    }
}
