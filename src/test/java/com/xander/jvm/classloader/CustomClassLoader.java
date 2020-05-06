package com.xander.jvm.classloader;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by zhaobing04 on 2020/4/9.
 *   * 一般2步
 * 1、重写findClass方法
 * 2、使用defineClass（）方法构建Class并返回
 */
public class CustomClassLoader extends ClassLoader{
    //定义从磁盘加载路径
    private String filePath;

    public CustomClassLoader(String filePath) {
        this.filePath = filePath;
    }

    /**
     * @param name
     * @return
     */
    @Override
    protected Class findClass(String name){
        //第一步 寻找字节码
        String classPath = filePath + name + ".class";
        byte[] classBytes = null;
        Path path = null;
        try{
            path = Paths.get(new URI(classPath));
            classBytes = Files.readAllBytes(path);
        }catch (Exception e){

        }
        //第二步 根据字节码组装Class对象，并返回
        return this.defineClass(name, classBytes, 0, classBytes.length);
    }
}
