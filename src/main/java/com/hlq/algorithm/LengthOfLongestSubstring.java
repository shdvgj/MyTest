package com.hlq.algorithm;

import java.util.HashMap;
import java.util.Map;


/**
 * 
 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @author Ricky
 *
 */
public class LengthOfLongestSubstring {
	// 算法基本思路 ，通过遍历将字符放入map ， 如果跟map中的值重复 ， 从重复的位置开始重新计数
	public int lengthOfLongestSubstring(String s) {
		char[] strings = s.toCharArray();
		int i = 0, max = 0, location = -1;
		Map<Character, Integer> singleMap 
			= new HashMap<Character, Integer>();
		int len = strings.length;
		for (int j = 0; j < len; j++) {
			Character ch = strings[j];
			Integer temp = singleMap.get(ch);
			// temp > location 的作用 ： 当前指针之前的所有数不作为重复值来统计
			if (temp != null && temp > location) {
				if (i > max) max = i;
				// location作为重复字符串的位置指针
				location = temp;
				// 不重复字符串数 = 当前指针位置 - 重复字符串的位置
				// 如advdfeg ， 那么在循环到第二个d时 ， j = 3 ， temp = 1 ， 不重复字符串数位2 ， 即vd 
				i = j - temp;
			} else {
				i++;
			}
			singleMap.put(ch, j);
		}
		if (i > max) max = i;
		return max;
	}
	
	public static void main(String[] args) {
		LengthOfLongestSubstring test = new LengthOfLongestSubstring();
		System.out.println(test.lengthOfLongestSubstring("pwwkew"));
	}
}
