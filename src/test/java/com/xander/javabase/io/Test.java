package com.xander.javabase.io;

import java.io.*;
import java.util.regex.Pattern;

/**
 * Created by zhaobing04 on 2020/6/19.
 */
public class Test {
    private static Pattern pattern = Pattern.compile("[0-9]+");

    public static void main(String[] args) {
        testFile();
        testStringFileter();
        runCmd();
    }

    public static void testFile(){
        //定义一个目录
        File dwork = new File("D:\\work");
        System.out.println("是目录？ " + dwork.isDirectory());
        System.out.println("是文件？ " + dwork.isFile());
        if(dwork.isDirectory()){
            String[] fileList = dwork.list();
            for(String file : fileList){
                System.out.println(file);
            }
        }
        System.out.println("\n过滤文件名中包含a字符的文件----------------------- \n");
        if(dwork.isDirectory()){
            String[] aFile = dwork.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.contains("a");
                }
            });
            for(String str : aFile){
                System.out.println(str);
            }
        }
    }
    public static void testStringFileter(){
        System.out.println(pattern.matcher("123456").matches());
        System.out.println(pattern.matcher("123adfds").matches());
        System.out.println(pattern.matcher("123adfds").find(2)); //从索引为2（包含索引为2的字符）的字符开始匹配
        System.out.println(pattern.matcher("123ad123").find(5));
    }

    public static void runCmd(){
        Runtime runtime=Runtime.getRuntime();
        String exec = "cmd /k & mvn -version";
        try {
            Process process = runtime.exec(exec);

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(),"GBK"));
            String s;
            while((s = reader.readLine()) != null){
                System.out.println(s);
            }
            process.waitFor();
            process.destroy();
            if(reader != null){
                reader.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
