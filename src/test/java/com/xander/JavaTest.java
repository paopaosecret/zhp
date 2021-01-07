package com.xander;

import com.alibaba.fastjson.JSON;
import com.sun.jndi.toolkit.url.Uri;
import com.xander.javabase.annotation.Start;
import com.xander.utils.StringUtil;
import com.xander.utils.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
//        int result = testFinally();
//        System.out.println("result :" + result);
//        System.out.println(0.01+0.05 == 0.06);
//        testLong();
//        String str = "1afda";
//        String bs = "fd";
//        if(str.contains(bs)){
//            System.out.println(str.indexOf(bs));
//        }
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

//        testJSON();
//        System.out.println(isHttpUrl("www.baidu.com"));
//        System.out.println(isHttpUrl("hao123.com"));
//        System.out.println(isHttpUrl("http://www"));
//        System.out.println(isHttpUrl(""));
        testA();
    }


    public static void testA(){
        String name = "上海锦囊妙计企业发展（集团）股份公司";
        if (StringUtil.isEmpty(name)) {
            System.out.println("请填写店铺名称");
            return;
        } else if (StringUtil.isEmoji(name) || StringUtil.isMobileNO(name)) {
            System.out.println("请重新输入店铺名称");
            return;
        } else if (!StringUtil.isLength(name)) {
            System.out.println("店铺名称字数在3~20字以内");
            return;
        } else{
            System.out.println("success");
        }

    }
    public static void testJSON(){
        ArrayList<String> symboltemBeans = new ArrayList<>();
        symboltemBeans.add("hyapp.58.con");
        symboltemBeans.add("app.58.com");
        System.out.println("---------------------------------------------------------------");
        String jsnoStr = JSON.toJSONString(symboltemBeans);
        System.out.println(jsnoStr);
        System.out.println("");
        System.out.println("");
        System.out.println("---------------------------------------------------------------");
        ArrayList<String> list = (ArrayList<String>) JSON.parseArray(jsnoStr, String.class);
        System.out.println(JSON.toJSONString(list));
    }

    /**
     * 判断字符串是否为URL
     * @param urls 需要判断的String类型url
     * @return true:是URL；false:不是URL
     */
    public static boolean isHttpUrl(String urls) {
        boolean isurl = false;
        String regex = "(((https|http)?://)?([a-z0-9]+[.])|(www.))"
                + "\\w+[.|\\/]([a-z0-9]{0,})?[[.]([a-z0-9]{0,})]+((/[\\S&&[^,;\u4E00-\u9FA5]]+)+)?([.][a-z0-9]{0,}+|/?)";//设置正则表达式

        Pattern pat = Pattern.compile(regex.trim());//对比
        Matcher mat = pat.matcher(urls.trim());
        isurl = mat.matches();//判断是否匹配
        if (isurl) {
            isurl = true;
        }
        return isurl;
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
