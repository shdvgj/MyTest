package com.hlq.algorithm;

/**
 * 给定一个字符串（以字符数组的形式给出）和一个偏移量，根据偏移量原地旋转字符串(从左向右旋转)

样例
样例 1:

输入:  str="abcdefg", offset = 3
输出:  str = "efgabcd"	
样例解释:  注意是原地旋转，即str旋转后为"efgabcd"
样例 2:

输入: str="abcdefg", offset = 0
输出: str = "abcdefg"	
样例解释: 注意是原地旋转，即str旋转后为"abcdefg"
样例 3:

输入: str="abcdefg", offset = 1
输出: str = "gabcdef"	
样例解释: 注意是原地旋转，即str旋转后为"gabcdef"
样例 4:

输入: str="abcdefg", offset =2
输出: str = "fgabcde"	
样例解释: 注意是原地旋转，即str旋转后为"fgabcde"
样例 5:

输入: str="abcdefg", offset = 10
输出: str = "efgabcd"	
样例解释: 注意是原地旋转，即str旋转后为"efgabcd"
挑战
在数组上原地旋转，使用O(1)的额外空间

注意事项
offset >= 0
str的长度 >= 0
 * @author Ricky
 * TODO
 */
public class RotateString {
	/**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
    	int realOffset = offset%str.length;
    	int i = str.length - realOffset;
    	char[] left = new char[i];
    	char[] right = new char[realOffset];
    	for (int k = 0; k < i; k++) {
			left[k] = str[k];
		}
    	for (int k = 0; k < realOffset; k++) {
			right[k] = str[i-k];
		}
    	for (int j = 0; j < right.length; j++) {
			str[j] = right[j];
		}
    	for (int j = 0; j < left.length; j++) {
			str[j] = left[j];
		}
    }
    
    public static void main(String[] args) {
    	char[] chars = "abcdefg".toCharArray();
		RotateString rotateString = new RotateString();
		rotateString.rotateString(chars, 2);
		for (char c : chars) {
			System.out.println(c);
		}
	}
}
