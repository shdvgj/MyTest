package com.hlq.algorithm;

/**
 实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
说明:

-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。

 * @author Ricky
 *
 */
public class MyPow {
	public double myPow(double x, int n) {
		if (n == 1) return x;
		if (n == 0) return 1;
		if (x == 0D) return 0D;
		if (n < 0) {
			x = 1/x;
			n = 0 - n;
		}
		int multiTime = 1;
		double result = x;
		while ((multiTime << 1) <= n 
				&& (multiTime << 1) != Integer.MIN_VALUE) {
			result = result * result;
			multiTime = multiTime << 1;
		}
		if (n - multiTime == 0) return result;
		result = result * myPow(x, n - multiTime);
		return result;
	}
	
	public static void main(String[] args) {
		MyPow myPow = new MyPow();
		System.out.println(myPow.myPow(1D,2147483647));
	}
}
