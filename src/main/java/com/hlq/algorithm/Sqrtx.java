package com.hlq.algorithm;

/**
 * 
 实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

输入: 4
输出: 2
示例 2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842..., 
     由于返回类型是整数，小数部分将被舍去。
     
 * @author Ricky
 *
 */
public class Sqrtx {
	// 思路 ： 位运算
	public int mySqrt(int x) {
		if (x <= 0 ) return 0;
		int i = 0;
		int result = 0;
		int sqrtx = 0;
		while(x>0) {
			sqrtx = (result + (1<<i)) * (result + (1<<i));
			// <=0用于判断大于2^32-1
			if (sqrtx > x || sqrtx <= 0) {
				result += 1<<(i-1);
				i = 0;
				int inResult = (result + 1) * (result + 1);
				if (inResult > x || inResult <= 0) return result;
			} else if (sqrtx == x) {
				result += 1<<i;
				return result;
			} else i++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Sqrtx sqrtx = new Sqrtx();
		System.out.println(sqrtx.mySqrt(25));
	}
}
