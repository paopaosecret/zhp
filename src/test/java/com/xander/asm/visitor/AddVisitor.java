package com.xander.asm.visitor;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * Created by zhaobing04 on 2019/7/31.
 */
public class AddVisitor extends ClassVisitor {
    public AddVisitor(ClassVisitor cv) {
        super(Opcodes.ASM4, cv);
    }

    @Override
    public void visit(int version, int access, String name,
                      String signature, String superName, String[] interfaces) {
        this.cv.visit(51, access,name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int i, String s, String s1, String s2, String[] strings) {
        // 删除方法
        if (s.startsWith("set")){
            return null;
        }
        // 修改方法的权限修饰符
        return cv.visitMethod(Opcodes.ACC_PRIVATE, s, s1, s2, strings);
    }
}
