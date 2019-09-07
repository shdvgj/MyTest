package com.hlq.algorithm;

import java.util.Stack;

/**
 * 给出两个整数 aa 和 bb , 求他们的和。

样例
样例 1:

输入:  a = 1, b = 2
输出: 3	
样例解释: 返回a+b的结果.
样例 2:

输入:  a = -1, b = 1
输出: 0	
样例解释: 返回a+b的结果.
挑战
显然你可以直接 return a + b，但是你是否可以挑战一下不这样做？（不使用++等算数运算符）

说明
a和b都是 32位 整数么？

是的
我可以使用位运算符么？

当然可以
注意事项
你不需要从输入流读入数据，只需要根据aplusb的两个参数a和b，计算他们的和并返回就行。
 * @author Ricky
 * TODO 目前无法处理负数相加
 */
public class AplusB {
	/**
     * 使用二进制的方式进行相加
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b 
     */
    public int aplusb(int a, int b) {
        char[] binaryA = Integer.toBinaryString(a).toCharArray();
        char[] binaryB = Integer.toBinaryString(b).toCharArray();
        // 二进制 11 + 11 = 110
        Stack<Character> stackA = new Stack<>();
        Stack<Character> stackB = new Stack<>();
        for (char charA : binaryA) {
            stackA.push(charA);
        }
        for (char charB : binaryB) {
            stackB.push(charB);
        }
        // 进一标记
        Boolean plusOne = false;
        Boolean stackIsEmpty = false;
        Stack<Character> result = new Stack<>();
        while (!stackIsEmpty) {
            Character charA = '0';
            Character charB = '0';
            if (!stackA.isEmpty()) {
                charA = stackA.pop();
            }
            if (!stackB.isEmpty()) {
                charB = stackB.pop();
            }
            if (charA == '1' && charB == '1') {
                if (plusOne) result.push('1');
                else {
                    result.push('0');
                    plusOne = true;
                }
            } else if (charA == '0' && charB == '0') {
                if (plusOne) {
                    result.push('1');
                    plusOne = false;
                } else {
                    result.push('0');
                }
            } else {
                if (plusOne) {
                    result.push('0');
                } else {
                    result.push('1');
                }
            }
            stackIsEmpty = stackA.isEmpty() && stackB.isEmpty();
        }
        if (plusOne) result.push('1');
        StringBuilder resultStr = new StringBuilder();
        while (!result.isEmpty()) {
            resultStr.append(result.pop());
        }
        return Integer.parseInt(resultStr.toString() , 2);
    }

    public static void main(String[] args) {
        AplusB aplusB = new AplusB();
        System.out.println(aplusB.aplusb(9999,-1));
    }
}
