package com.hlq.algorithm;

import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，
 * 写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：

任何左括号 ( 必须有相应的右括号 )。
任何右括号 ) 必须有相应的左括号 ( 。
左括号 ( 必须在对应的右括号之前 )。
* 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
一个空字符串也被视为有效字符串。
示例 1:

输入: "()"
输出: True
示例 2:

输入: "(*)"
输出: True
示例 3:

输入: "(*))"
输出: True
注意:

字符串大小将在 [1，100] 范围内。

 * @author Ricky
 *
 */
public class CheckValidString {
	public boolean checkValidString(String s) {
		Stack<Character> leftStack = new Stack<>();
		Stack<Integer> leftIndexList = new Stack<>();
		Stack<Character> starStack = new Stack<>();
		Stack<Integer> starIndexList = new Stack<>();
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			Character c = chars[i];
			if (c == '(') {
				leftStack.push(c);
				leftIndexList.push(i);
			} else if (c == '*') {
				starStack.push(c);
				starIndexList.push(i);
			} else if (c == ')') {
				if (leftStack.isEmpty()) {
					if (starStack.isEmpty()) return false;
					starStack.pop();
					starIndexList.pop();
				} else {
					leftStack.pop();
					leftIndexList.pop();
				}
			}
		}
		while (!leftStack.isEmpty()) {
			if (!starStack.isEmpty()) {
				Integer left = leftIndexList.pop();
				Integer star = starIndexList.pop();
				if (left > star) return false;
				starStack.pop();
				leftStack.pop();
			} else return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		CheckValidString checkValidString = new CheckValidString();
		System.out.println(checkValidString.checkValidString("***)))"));
	}
}
