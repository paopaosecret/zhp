package com.xander.aop.asm;

import com.xander.aop.asm.visitor.AddVisitor;
import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//import asm.visitor.PrinterVisitor;

/**
 * Created by zhaobing04 on 2019/7/9.
 */
public class ASMDemo {
    public static void init(){
//        User user = new User();
        System.out.println("初始化完成");
    }
    public static void main(String args[]){
//        init();
//        parseClass();
        testClassWriter();

    }

    public static void testClassReader(){
        try {
            ClassReader classReader = new ClassReader("D:\\idea\\project\\typedemo\\out\\production\\typedemo\\asm\\entity\\User.class");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * 使用ASM生成的类
     */
    public static void testClassWriter(){
        //使用Asm生成class字节码二进制流
        byte[] bytes = generate();

        String path = "D:\\idea\\project\\typedemo\\out\\production\\typedemo\\asm\\entity\\Asm.class";
        writeFile(path, bytes);

        // 使用自定义的ClassLoader
        MyClassLoader cl = new MyClassLoader();
        // 加载我们生成的 HelloWorld 类
        Class<?> clazz = cl.defineClass("asm.entity.Asm", bytes);
        System.out.println("clazz classLoader:" + clazz.getClassLoader());
        // 反射获取 main 方法
        Method main = null;
        try {
            main = clazz.getMethod("main", String[].class);
            // 调用 main 方法
            main.invoke(null, new Object[]{new String[]{}});

            System.out.println("MyClassLoader parent:" + clazz.getClassLoader().getParent());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    /**
     * 将二进制流写入文件
     * @param path
     * @param bytes
     */
    public static void writeFile(String path, byte[] bytes){
        File file = new File(path);
        FileOutputStream fileOutputStream = null;
        try {
            if(file == null){
                System.out.println("文件不存在");
            }else if(file.exists()){
                file.delete();
                file.createNewFile();

            }else{
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 生成一个类的二进制流
     * @return
     */
    public static byte[] generate() {
        ClassWriter cw = new ClassWriter(0);
        // 定义对象头：版本号、修饰符、全路径类名、签名、父类、实现的接口
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "asm/entity/Asm",
                null, "java/lang/Object", null);
        // 添加方法：修饰符、方法名、描述符、签名、抛出的异常
        cw.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC +  Opcodes.ACC_FINAL, "count", "I", null, new Integer(10)).visitEnd();
        MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main",
                "([Ljava/lang/String;)V", null, null);
        // 执行指令：获取静态属性
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        // 加载常量 load constant
        mv.visitLdcInsn("HelloWorld!");

        // 调用方法
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        // 返回
        mv.visitInsn(Opcodes.RETURN);
        // 设置栈大小和局部变量表大小
        mv.visitMaxs(2, 1);
        // 方法结束
        mv.visitEnd();
        // 类完成
        cw.visitEnd();
        // 生成字节数组
        return cw.toByteArray();
    }

    /**
     * 使用ASM解析类
     */
    public static void parseClass(){
        try {
            ClassWriter classWriter=new ClassWriter(3);
            AddVisitor addVisitor = new AddVisitor(classWriter);
            ClassReader classReader = new ClassReader("asm.entity.User");
            classReader.accept(addVisitor, 0);
            String path = "D:\\idea\\project\\typedemo\\out\\production\\typedemo\\asm\\entity\\User.class";
            writeFile(path, classWriter.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

