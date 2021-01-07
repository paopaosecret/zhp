package com.xander.compile.zcompile.词法分析;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaobing04 on 2020/11/30.
 * 基于//README.MD中定义的语言实现词法分析过程
 */
public class Tokenizer {
    public static void main(String[] args) {
        Reader br = null;
        List<String> tokenList = new ArrayList<>();
        int state = 1;
        try {
            if (args != null && args.length == 1) {
                String fileName = args[0];
                System.out.println(fileName);
                File file = new File("D:\\idea\\gitproject\\zhp\\src\\test\\java\\com\\xander\\compile\\zcompile", fileName);
                if (!file.exists()) {
                    System.out.println("文件不存在");
                } else {
                    br = new BufferedReader(new FileReader(file));
                    int len = br.read();
                    StringBuffer sb = new StringBuffer("");

                    while( len != -1){
                        if(len >= 48 && len <= 57 ){//0-9
                            if(state == 1 || state == 2){
                               state = 2;
                               sb.append((char)len);
                            }else{
                                System.out.println((char)len + "前置状态非法");
                            }
                        }else if(len >= 97 && len <= 122){//a-z
                            if(state == 1 || state == 3){
                                state = 3;
                                sb.append((char)len);
                            }else{
                                System.out.println((char)len + "前置状态非法");
                            }
                        }else if(len == '+' || len == '-'  || len == '*' || len == '/' || len == '.' || len == '='
                                || len == '{'  || len == '}'  || len == ';' ){ //+ - x /  = { } ;
                            if(state == 1){
                                state = 4;
                               sb.append((char)len);
                            }else{
                                System.out.println((char)len + "前置状态非法");
                            }
                        }else if(len == ' ' || len == '\n'){
                            if(state != 1){
                                state = 1;
                                tokenList.add(sb.toString());
                                sb.delete(0, sb.toString().length());
                            }
                        }
                        len = br.read();
                    }
                    if("}".equals(sb.toString())){
                        tokenList.add("}");
                    }else{
                        System.out.println("错误的程序结束符：" + sb.toString());
                    }
                }
            } else {
                System.out.println("请输入需要进行词法分析的文件名");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(tokenList);
    }
}
