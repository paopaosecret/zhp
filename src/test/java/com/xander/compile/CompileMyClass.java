package com.xander.compile;

import javax.tools.*;

public class CompileMyClass {
	public static void main(String args[]) {
		JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
		int result = jc.run(null, null, null, "D:\\idea\\gitproject\\zhp\\src\\test\\java\\com\\xander\\compile\\MyClass.java");
		System.out.println(result == 0 ? "编译成功" : "编译失败");
	}
}