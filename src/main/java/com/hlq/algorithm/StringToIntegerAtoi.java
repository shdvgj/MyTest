package com.hlq.algorithm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
请你来实现一个 atoi 函数，使其能将字符串转换成整数。

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：

假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。
如果数值超过这个范围，返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。

示例 1:

输入: "42"
输出: 42
示例 2:

输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
示例 3:

输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
示例 4:

输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     因此无法执行有效的转换。
示例 5:

输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。 
     因此返回 INT_MIN (−2^31) 。
 * @author 49781
 *
 */
public class StringToIntegerAtoi {
	/**
	 * 正则表达式的方式
	 * @param str
	 * @return
	 */
	public int myAtoi(String str) {
		Pattern pattern = Pattern.compile("^[+-]?\\d+");
		Matcher matcher = pattern.matcher(str.trim());
		int result = 0;
		if (matcher.find()) {
			String s = "";
			try {
				s = matcher.group(0);
				if (s.isEmpty()) return 0;
				result = Integer.parseInt(s);
			} catch (NumberFormatException e) {
				// 如果超出int的范围 ， 就返回int的最大值或者最小值
				if (s.startsWith("-")) {
					return Integer.MIN_VALUE;
				} else {
					return Integer.MAX_VALUE;
				}
			}
		}
		return result;
	}
	
	/**
	 * 遍历的方式
	 * @param str
	 * @return
	 */
	public int myAtoi_V2(String str) {
		char[] chs = str.toCharArray();
		int result = 0;
		char symbol = '*';
		boolean overMax = false;
		for (Character ch : chs) {
			int chNum = 0;
			if (ch == ' ' ) {
				if (symbol != '*') break;
				continue;
			}
			if (symbol != '*' && (ch == '+' || ch == '-')) break;
			if (ch == '+' || ch == '-') {
				symbol = ch;
				continue;
			}
			try {
				chNum = Integer.parseInt(ch.toString());
			} catch (Exception e) {
				break;
			}
			if (result> (Integer.MAX_VALUE - chNum)/10) {
				overMax = true;
				break;
			}
			result = result * 10 + chNum;
			if (symbol == '*') symbol = '+';
		}
		if (symbol == '-') {
			if (overMax) return Integer.MIN_VALUE;
			result = result * -1; 
		} else {
			if (overMax) return Integer.MAX_VALUE;
		}
		return result;
	}
	
	public static void main(String[] args) {
		StringToIntegerAtoi stringToIntegerAtoi = new StringToIntegerAtoi();
		System.out.println(stringToIntegerAtoi.myAtoi_V2("   +0 123"));
	}
}
