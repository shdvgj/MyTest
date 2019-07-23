package com.hlq.algorithm;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。

示例 1:

输入: "abc"
输出: 3
解释: 三个回文子串: "a", "b", "c".
示例 2:

输入: "aaa"
输出: 6
说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
注意:

输入的字符串长度不会超过1000。

 * @author Ricky
 *
 */
public class PalindromicSubstrings {
	public int palindromicSubstrings(String s) {
		int length = s.length();
		int result = 0;
		for (int i = 0; i < length; i++) {
			for (int j = i+1; j <= length; j++) {
				String str = s.substring(i, j);
				StringBuilder reverseStr = new StringBuilder(str).reverse();
				if (str.equals(reverseStr.toString())) {
					System.out.println(str);
					result++;
				} 
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
		System.out.println(palindromicSubstrings.palindromicSubstrings("aaabc"));
	}
}
