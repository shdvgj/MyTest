package com.hlq.algorithm;

/**
 * 
 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。

注意：整数顺序将表示为一个字符串。

 

示例 1:

输入: 1
输出: "1"
示例 2:

输入: 4
输出: "1211"
 * @author Ricky
 * TODO 需要优化
 */
public class CountAndSay {
	public String countAndSay(int n) {
		String result = "1";
		char notDuplacate = '1';
		Integer count = 0;
		String temp = "";
		for (int i = 2; i <= n; i++) {
			temp = new String(result);
			result = "";
			/*
			 *  1.     1
				2.     11
				3.     21
				4.     1211
				5.     111221
			 */
			for (int j = temp.length() - 1; j >= 0; j--) {
				char ch = temp.charAt(j);
				if (notDuplacate == ch) {
					count ++;
				} else {
					result = (count > 0 ? count.toString() : "") + notDuplacate + result;
					notDuplacate = ch;
					count = 1;
				}
			}
			result = (count > 0 ? count.toString() : "") + notDuplacate + result;
			count = 0;
			notDuplacate = '1';
		}
		return result;
	}
	
	// 递归实现
	public String countAndSay_V2(int n) {
		if(n>1) {
			String result = countAndSay_V2(n-1);
			String temp = new String(result);
			result = "";
			char notDuplacate = '1';
			Integer count = 0;
			for (int j = temp.length() - 1; j >= 0; j--) {
				char ch = temp.charAt(j);
				if (notDuplacate == ch) {
					count ++;
				} else {
					result = (count > 0 ? count.toString() : "") + notDuplacate + result;
					notDuplacate = ch;
					count = 1;
				}
			}
			return (count > 0 ? count.toString() : "") + notDuplacate + result;
		} 
		return "1";
	}
	
	public static void main(String[] args) {
		CountAndSay countAndSay = new CountAndSay();
		System.out.println(countAndSay.countAndSay(4));
		System.out.println(countAndSay.countAndSay_V2(4));
	}
}
