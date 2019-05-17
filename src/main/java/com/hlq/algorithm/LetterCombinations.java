package com.hlq.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * @author Ricky
 *
 */
public class LetterCombinations {
	static final Map<Character, Character[]> numLetterMap = new HashMap<Character, Character[]>(){{
		put('2', new Character[]{'a','b','c'});
		put('3', new Character[]{'d','e','f'});
		put('4', new Character[]{'g','h','i'});
		put('5', new Character[]{'j','k','l'});
		put('6', new Character[]{'m','n','o'});
		put('7', new Character[]{'p','q','r','s'});
		put('8', new Character[]{'t','u','v'});
		put('9', new Character[]{'w','x','y','z'});
	}};
	
	// TODO 优化
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		char[] digitChars = digits.toCharArray();
		boolean flag = false;
		for (int j = 0 ; j<digitChars.length; j++) {
			char c = digitChars[j];
			Character[] characters = numLetterMap.get(c);
			if (!result.isEmpty()) flag = true;
			List<String> newResult = new ArrayList<String>();
			for (Character character : characters) {
				String strNew = character.toString();
				if (!flag) {
					newResult.add(strNew);
				} else {
					for (int i = 0; i < result.size(); i++) {
						newResult.add(result.get(i) + strNew);
					}
				}
			}
			result = newResult;
		}
		return result;
	}
	
	public static void main(String[] args) {
		LetterCombinations letterCombinations = new LetterCombinations();
		List<String> result = letterCombinations.letterCombinations("234");
		for (String string : result) {
			System.out.println(string);
		}
	}
}
