package com.hlq.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
n = 2
()()
(())

()()()
(()())
(())()
()(())
((()))

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
1,2,3
1,2,4
1,2,5
1,3,4
1,3,5
n=4
(((())))
1,2,3,4
((()()))
1,2,3,5
((())())
1,2,3,6
((()))()
1,2,3,7
 * @author Ricky
 */
public class GenerateParenthesis {
	// ()()()()()
	// (()())(()())()
	// ((()))(()())()
	// 思路：所有的()加上一堆括号的可能性是在前后加()或者在两边加()
	// TODO 思路错误，结果不对
	public List<String> generateParenthesis(int n) {
		Set<String> result = new HashSet<String>();
		String parenthesis = "()";
		result.add(parenthesis);
		for (int i = 1; i < n; i++) {
			Set<String> newResult = new HashSet<String>();
			for (String string : result) {
				newResult.add("(" + string + ")");
				newResult.add(string + "()");
				newResult.add("()" + string);
			}
			result = newResult;
		}
		return new ArrayList<String>(result);
	}
	
	public static void main(String[] args) {
		GenerateParenthesis generateParenthesis = new GenerateParenthesis();
		List<String> result = generateParenthesis.generateParenthesis(4);
		for (String string : result) {
			System.out.println(string);
		}
	}
}
