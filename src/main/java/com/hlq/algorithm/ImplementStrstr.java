package com.hlq.algorithm;

/**
 * 
 实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * @author Ricky
 *
 */
public class ImplementStrstr {
	public int strStr(String haystack, String needle) {
		int num = needle.length();
		int len = haystack.length();
		if (len < num) return -1;
		for (int i = 0; i <= len - num; i++) {
			String s = haystack.substring(i, i + num);
			if (s.equals(needle)) return i;
		}
		return -1;
	}
	
	// kmp 算法  https://www.zhihu.com/question/21923021
	/*public int kmp(String haystack, String needle) {
		// 以abaab为例 ， 前缀是以a开头 ， 后缀是以b结尾
		// ba a ; a ab aba
		// a ab ; baa aa a
		char[] needles = needle.toCharArray();
		int len = needle.length();
		int[] next = new int[len];
		// 匹配表第一个值必定是0 ， 因为没有前后缀可以匹配上
		next[0] = -1;
		// 获取匹配表（也是kmp算法最重要的一个东西） , 匹配表记录的数值指的字符串的前缀集合与后缀集合的交集中最长元素的长度-1
		// 如abaab , 对于ab子串来说 ，没有公共字符串，则next[1] = -1
		// 对于aba子串来说 ， 有公共字符串 ， 就是a ， 其最后位置在0 ， 所以next[2] = 0;
		// 对于abaab子串来说 ， 最大公共字符串是ab ， 其最后位置在1 ， 所以next[4] = 1;
		for (int j = 1; j < len; j++) {
			 nextVal就是最大前缀最后一位对应的索引 
			int nextVal = next[j-1];
			 任何一个最大前缀后一位与当前求值字符相同时或者向前继续寻找的索引为-1时停止循环 
			// 比如 
			// index   0123456789
			//         abaababbaa
			// next+1  0011232011
			while(nextVal >= 0 && needles[nextVal+1]!=needles[j]) 
				nextVal = next[nextVal];
			 字符相同，公共最大长+1，next值+1 
			if (needles[nextVal + 1] == needles[j]) {
				next[j] = nextVal + 1;
			} else {
				 最终寻找到的索引为-1，公共最大长归零 
				next[j] = -1;
			}
			
		}
		// 得到匹配表之后 ， 就将简化字符串查询的步骤
		char[] hayStacks = haystack.toCharArray();
		for (int i = 0 , j = 0; i < hayStacks.length;) {
			if(hayStacks[i] == needles[j]) {
				i++;
				j++;
			} else {
				i = i + next[j] + 1;
				j = 0;
			};
			// 已经匹配完毕
			if (j == len) return i-j;
		}
		return -1;
	}*/
	
	public static void main(String[] args) {
		ImplementStrstr implementStrstr = new ImplementStrstr();
		System.out.println(implementStrstr.strStr("aabbbaabaab", "bbaa"));
	}
}
