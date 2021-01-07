package com.xander.utils;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zhaobing04 on 2021/1/7.
 */
public class MD5Utils {
    public static String genMD5CheckSum(File file) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            messageDigest.update(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] digestBytes = messageDigest.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digestBytes) {
            sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        File file = new File("E:\\android\\系统编译\\aosp源代码\\aosp-latest.tar");
        System.out.println("------------------------------------------------------");
        System.out.println(genMD5CheckSum2(file));
        System.out.println("------------------------------------------------------");
    }

    public static String genMD5CheckSum2(File file){
        /**
         * 使用Guava
         */
        HashCode md5Hash = null;
        try {
            md5Hash = com.google.common.io.Files.hash(file, Hashing.md5());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return md5Hash.toString();
    }
}
