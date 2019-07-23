package com.hlq.algorithm;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。

 

示例 1：

输入: "the sky is blue"
输出: "blue is sky the"
示例 2：

输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
示例 3：

输入: "a good example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 

说明：

无空格字符构成一个单词。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

 * @author Ricky
 *
 */
public class ReverseWords {
	public String reverseWords(String s) {
		if (s == null || s.isEmpty()) return s;
		String[] strs = s.split(" ");
		if (strs == null || strs.length == 0) return "";
		StringBuilder result = new StringBuilder();
		for (int i = strs.length - 1; i >= 0; i--) {
			String string = strs[i];
			if (string.isEmpty()) continue;
			result.append(string).append(" ");
		}
		return result.substring(0,result.length()-1);
	}
	
	public static void main(String[] args) {
		ReverseWords reverseWords = new ReverseWords();
		System.out.println(reverseWords.reverseWords(" "));
	}
}
