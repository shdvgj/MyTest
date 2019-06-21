package com.hlq.forjob;

/**
 * java 1.8 可以创建默认方法和静态方法
 * @author Ricky
 *
 */
public interface DefaultMethodInterface {
	void defaultInteface(int i);
	default int defaultMethod(int i) {
		return i;
	}
	static int defaultStaticMethod(int i) {
		return i;
	}
}
