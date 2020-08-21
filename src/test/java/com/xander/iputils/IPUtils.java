package com.xander.iputils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by zhaobing04 on 2020/8/21.
 *
 * 方式1：{@link IPUtils #getInfoByIP138}
 * 使用IP138查询
 * 获取iP地址对应的省市区以及运营商名称
 * 可以查询ip对应的城市名称  城市座机号   邮编   网络运营商信息
 *
 *
 */
public class IPUtils {
    public static void main(String[] args) {
//        queryIP("111.206.15.44");
        getInfoFree("111.206.15.44");
    }

    public static String getInfoByIP138(String urlString,String token) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5 * 1000);
            conn.setReadTimeout(5 * 1000);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("token",token);
            int responseCode = conn.getResponseCode();
            //返回202 token 无效，有可能免费次数用完或者充值之后的次数也用完了
            if (responseCode == 200) {
                StringBuilder builder = new StringBuilder();
                BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(),"utf-8"));
                for (String s = br.readLine(); s != null; s = br.readLine()) {
                    builder.append(s);
                }
                br.close();
                return builder.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    //        http协议： http://api.ip138.com/ipv4/
    //        https协议：https://api.ip138.com/ipv4/
    public static void queryIP(String ip){
        //第一步：https://user.ip138.com/reg/  需要注册申请token
        //第二步：替换下面中的token
        String DATATYPE="text";
        String url="https://api.ip138.com/ipv4/?ip="+ip+"&datatype="+DATATYPE;
        String token="6d7041c592fced8a2dbb63e4b5656599";
        String result = getInfoByIP138(url,token);
        System.out.println(result);
    }

//    查询指定IP数据免费方法
//    http://freeapi.ipip.net/8.8.8.8
//    http://ip.taobao.com/service/getIpInfo.php?ip=8.8.8.8
//    https://ip.ws.126.net/ipquery?ip=8.8.8.8
//    http://pv.sohu.com/cityjson 搜狐
    public static void getInfoFree(String ip) {
        try {
            URL url = new URL("http://freeapi.ipip.net/" + ip);      //注意为UTF-8编码
//            URL url = new URL("https://ip.ws.126.net/ipquery?ip=" + ip); //注意为GBK编码
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5 * 1000);
            conn.setReadTimeout(5 * 1000);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestMethod("GET");
            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                StringBuilder builder = new StringBuilder();
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(),"UTF-8"));
                for (String s = br.readLine(); s != null; s = br.readLine()) {
                    builder.append(s);
                }
                br.close();
                System.out.println(builder.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
