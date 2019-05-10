package com.hlq.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
 * @author Ricky
 *
 */
public class ValidParentheses {
	final static Map<Character, Character> parenthesesMap 
		= new HashMap<Character, Character>(){{
			put('[', ']');
			put('(', ')');
			put('{', '}');
		}};
	
	/*
	 * 方法1：通过堆栈将所有左括号对应的右括号值填入，按顺序排列，然后依次取得右括号将堆栈内的右括号消耗
	 */
	public boolean isValid(String s) {
		// 如果数组长度是奇数 ， 直接返回false
		if (s.length() % 2 == 1) return false;
		if (s.isEmpty()) return true;
		char[] chars = s.toCharArray();
		int len = chars.length;
		// pop：取出顶部的值 ， peek：只查看顶部的值
		Stack<Character> sortStack = new Stack<Character>();
		for (int i = 0; i < len; i++) {
			// 如果剩余的左括号的数量大于剩余的字符数量 ， 返回false
			if (sortStack.size() > len -i) return false;
			Character ch = chars[i];
			// 获取对应值
			Character right = parenthesesMap.get(ch);
			if (right == null) {
				// 如果right不是栈内的值 ， 返回false
				if(!sortStack.contains(ch)) return false;
				Character nowCh = sortStack.pop();
				if (!nowCh.equals(ch)) return false;
			} else {
				// 将所有的左括号对应的右括号记录下来
				sortStack.add(right);
			}
		}
		// 如果所有的左括号的位置都被清空 ， 说明所有左括号都被匹配上 ， 返回true
		return sortStack.isEmpty();
	}
	
	// 方法2：符合条件的字符串必定符合将所有的(){}[]替换后为空字符的条件 , 简单 ， 但是低效
	public boolean isValid_V2(String s) {
		while(true){
			int len = s.length();
			if (len == 0) return true;
			s = s.replace("()", "")
			.replace("[]", "")
			.replace("{}", "");
			if(s.length() == 0) return true;
			if(s.length() == len) break;
		}
		return false;
	}
	
	public static void main(String[] args) {
		ValidParentheses validParentheses = new ValidParentheses();
		//[]{}[] , ([]{})[] 
		System.out.println(validParentheses.isValid_V2("([]{})[]{"));
	}
}
