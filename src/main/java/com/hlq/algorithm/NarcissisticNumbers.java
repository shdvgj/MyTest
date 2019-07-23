package com.hlq.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 水仙花数的定义是，这个数等于他每一位上数的幂次之和 见维基百科的定义

比如一个3位的十进制整数153就是一个水仙花数。因为 153 = 1^3 + 5^3 + 3^3。

而一个4位的十进制数1634也是一个水仙花数，因为 1634 = 1^4 + 6^4 + 3^4 + 4^4。

给出n，找到所有的n位十进制水仙花数。

样例
样例 1:

输入: 1
输出: [0,1,2,3,4,5,6,7,8,9]
样例 2:

输入:  2
输出: []	
样例解释: 没有2位数的水仙花数。
注意事项
你可以认为n小于8。
 * @author Ricky
 *
 */
public class NarcissisticNumbers {
	/**
     * @param n: The number of digits
     * @return: All narcissistic numbers with n digits
     */
    public List<Integer> getNarcissisticNumbers(int n) {
    	double max = Math.pow(10, n);
    	int min = (int)Math.pow(10, n-1);
    	if (n == 1) min = 0;
    	List<Integer> result = new ArrayList<>();
    	for (Integer i = min; i < max; i++) {
    		int sumResult = 0;
    		int temp = i;
    		for (int j = 0; j < n; j++) {
				sumResult += Math.pow(temp%10,n);
				temp /= 10;
			}
    		if (sumResult == i) result.add(sumResult);
		}
        return result;
    }
    
    public static void main(String[] args) {
		NarcissisticNumbers narcissisticNumbers = new NarcissisticNumbers();
		List<Integer> list = narcissisticNumbers.getNarcissisticNumbers(5);
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
    
}
