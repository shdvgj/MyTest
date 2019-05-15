package com.hlq.algorithm;

import java.util.ArrayList;
import java.util.List;

/***
 * 
 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G
 * @author Ricky
 *
 */
public class ZigzagConversion {
	public String convert(String s, int numRows) {
		if (s.isEmpty()) return "";
		if (numRows == 1) return s;
		// 用于取余的数
		int multiNum = (numRows + numRows - 2);
		int len = s.length();
		List<Character>[] lists = new ArrayList[numRows];
		for(int i = 0; i < len; i++) {
			int num = i % multiNum;
			// 如果取余之后大于行数 ， 将该行数确定为1-4行中的一行
			if (num + 1 > numRows) {
				/**
				 *比如第五个字符C ， 它所属的列是第三列 ， 先用位置下标4%6 ， 获得余数4，这个数字是队列的下标
				 *这个超出了上文中设置的队列数量 ， 上文中设置了4个队列 ， 最大的队列下标是3
				 *其超出最大下标一个位置 ， 根据预设的4个队列 ， 减去该超出的位置数量 ， 就获得了新的队列下标位置
				L     D     R
				E   O E   I I
				E C   I H   N
				T     S     G
				 */
				num = numRows - (num + 1 - numRows) - 1;
			}
			if (lists[num] == null) lists[num] = new ArrayList<Character>();
			lists[num].add(s.charAt(i));
		}
		StringBuilder resultStr = new StringBuilder();
		for (List<Character> list : lists) {
			if (list == null || list.isEmpty()) break;
			for (Character character : list) {
				resultStr.append(character);
			}
		}
		return resultStr.toString();
	}
	
	public static void main(String[] args) {
		ZigzagConversion zigzagConversion = new ZigzagConversion();
		System.out.println(zigzagConversion.convert("A", 4));
	}
}
