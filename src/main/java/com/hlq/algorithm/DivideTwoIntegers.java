package com.hlq.algorithm;

/**
 * 
给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 dividend 除以除数 divisor 得到的商。

示例 1:

输入: dividend = 10, divisor = 3
输出: 3
示例 2:
111 11
输入: dividend = 7, divisor = -3
输出: -2
说明:

被除数和除数均为 32 位有符号整数。
除数不为 0。
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
 * @author Ricky
 * 100/2 = 50
 * 100/2 = 2*32 + 36;
 * 36/2 = 2*16 + 8
 * 8/2 = 2*2
 * 32+16+2 = 50
 * @farorite
 */
public class DivideTwoIntegers {
	
	// 位运算 + 递归实现
	// 思路 : 所有的数字都可以用二进制来表示
	/* 计算过程如下
	 * 100/2 = 2*32 + 2*16 + 2*2;
	 * 32+16+2 = 50
	 * 100/3 = 3*32 + 3*1
	 * 32 + 1 = 33
	*/
	public int divide(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		// 全部记录为负数，统一符号，同时避免最大负数转为正数时会溢出的问题
		int positiveDividend = dividend > 0 ? 0 - dividend : dividend;
		int positiveDivisor = divisor > 0 ? 0 - divisor : divisor;
		// 记录位运算左移次数
		int leftTime = 0;
		int result = 0;
		// 记录最小整数右移一位的结果
		int maxRight1 = Integer.MIN_VALUE >> 1;
		if (dividend == 0 || positiveDividend - positiveDivisor > 0) return 0;
		while (positiveDividend - positiveDivisor < 0) {
			// 如果除数大于最大整数/2，说明不能再左移了，跳出循环
			if (positiveDivisor < maxRight1 || positiveDividend - (positiveDivisor << 1) > 0) break;
			positiveDivisor = positiveDivisor << 1;
			leftTime ++;
		}
		// 递归
		result = (1 << leftTime) 
				+ divide(positiveDividend - positiveDivisor, divisor > 0 ? 0 - divisor : divisor);
		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
			result = 0 - result;
		}
		return result;
	}
	
	public static void main(String[] args) {
		DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
		System.out.println(divideTwoIntegers.divide(-2147483648,-2147483648));
	}
}
