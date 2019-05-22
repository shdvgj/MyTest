package com.hlq.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

如果不存在最后一个单词，请返回 0 。

说明：一个单词是指由字母组成，但不包含任何空格的字符串。

示例:

输入: "Hello World"
输出: 5
 * @author Ricky
 *
 */
public class LengthOfLastWord {
	final static String letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
    public int lengthOfLastWord(String s) {
    	if (s == null || s.isEmpty()) return 0;
    	char[] chars = s.toCharArray();
    	int result = 0;
    	boolean otherChar = false;
    	for (char c : chars) {
			if (letter.indexOf(c) > -1) {
				if (otherChar) {
					result = 0;
					otherChar = false;
				}
				result ++;
			} else otherChar = true;
		}
    	return result;
    }
    
    public static void main(String[] args) {
    	LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
    	System.out.println(lengthOfLastWord.lengthOfLastWord(" HELLO1111"));
	}
    
    
}
