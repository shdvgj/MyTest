package com.hlq.algorithm;

/**
 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * @author Ricky
 *
 */
public class IsPalindrome {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		if (x == 0)
			return true;
		int pop = 0;
		int result = 0;
		// 原始数字
		int origin = x;
		while (x != 0) {
			pop = x % 10;
			// 判断如果反转后的数字大于最大的int ， 说明该数字不是回文数字
			if (x > 0 && result > (Integer.MAX_VALUE - pop)/10) {
				return false;
			}
			x /= 10;
			result = result * 10 + pop;
		}
		return origin == result;
	}
	
	public static void main(String[] args) {
		IsPalindrome isPalindrome = new IsPalindrome();
		System.out.println(isPalindrome.isPalindrome(1111));
	}
}
