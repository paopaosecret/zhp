package com.xander.asm.adapter;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.FieldVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

/**
 * Created by zhaobing04 on 2019/7/11.
 */
public class AccessClassAdapter extends ClassAdapter {

    public AccessClassAdapter(ClassVisitor cv) {
        super(cv);
    }

    public FieldVisitor visitFiled(final int access, final String name, final String desc, final String signature, final Object value){
        int privateAccess = Opcodes.ACC_PRIVATE;
        return cv.visitField(privateAccess,name, desc, signature, value);
    }
}
