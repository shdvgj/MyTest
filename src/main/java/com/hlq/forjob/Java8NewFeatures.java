package com.hlq.forjob;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Java8NewFeatures {
	/**
	 * 1.接口拥有了默认方法
	 * @see DefaultMethodInterface
	 */
	public void defaultMethod() {
		// 不管是抽象类还是接口，都可以通过匿名内部类的方式访问。
		// 我们可以这样理解：一个内部类实现了接口里的抽象方法并且返回一个内部类对象，之后我们让接口的引用来指向这个对象。
		DefaultMethodInterface defaultMethodInterface = 
				new DefaultMethodInterface() {
					@Override
					public void defaultInteface(int i) {
						return;
					}
				};
		// 接口的静态方法可以直接访问
		System.out.println(DefaultMethodInterface.defaultStaticMethod(1));
		// 接口的默认方法可以用匿名内部类来调用
		System.out.println(defaultMethodInterface.defaultMethod(2));
	}
	
	/**
	 * 2.lamda表达式
	 */
	public void lamdaExpression() {
		List<String> arrays = Arrays.asList("a","b","c");
		//(a,b) -> a.compareTo(b)相当于重写了comparator的compare方法
		arrays.sort((a,b) -> a.compareTo(b));
		
		
	}
	
	public static void main(String[] args) {
		Java8NewFeatures java8NewFeatures = new Java8NewFeatures();
		java8NewFeatures.defaultMethod();
	}
}
