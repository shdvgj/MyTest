package com.hlq.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 
 编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。
 * @author Ricky
 *
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) return "";
		// 直接将数组的第一个进行赋值
		String result = strs[0];
		for (int j = 1; j < strs.length; j++) {
			String string = strs[j];
			if (string.isEmpty()) return "";
			// 取当前循环中的字符串长度和结果字符串的长度中的较小值
			int len = string.length() > result.length() ? result.length() : string.length();
			// 将循环的字符串和结果字符串都截取为两者中的更小长度
			result = result.substring(0, len);
			string = string.substring(0, len);
			char[] singleStrs = string.toCharArray();
			for (int i = 0; i < len; i++) {
				char singleChar = singleStrs[i];
				// 如果当前字符和结果字符串中相同位置的字符不同 ， 就将结果字符串截取到这个字符前的结果
				if (result.charAt(i) != singleChar) {
					result = result.substring(0, i);
					break;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
//		System.out.println(longestCommonPrefix.longestCommonPrefix(new String[] {"flower","flow","flight"}));
//		System.out.println(longestCommonPrefix.longestCommonPrefix(new String[] {"dog","doglll","dogaaaa"}));
		System.out.println(longestCommonPrefix.longestCommonPrefix(new String[] {"baab","bacb","b","cbc"}));
	}
}
