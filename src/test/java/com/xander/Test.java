package com.xander;

import java.net.URLEncoder;

public class Test {
    public static void main(String[] args) {
        String streamId = "1400188366_12345_12345_main";
        try {
            streamId = URLEncoder.encode(streamId, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 拼接旁路流地址
        final String playUrl = "http://3891.liveplay.myqcloud.com/live/" + streamId + ".flv";
        System.out.println("播放地址：" + playUrl);

    }
}
