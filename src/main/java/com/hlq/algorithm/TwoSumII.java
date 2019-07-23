package com.hlq.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

说明:

返回的下标值（index1 和 index2）不是从零开始的。
你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
示例:

输入: numbers = [2, 7, 11, 15], target = 9
输出: [1,2]
解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。

 * @author Ricky
 *
 */
public class TwoSumII {
	// map法
	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> numMap = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			numMap.put(numbers[i], i);
		}
		int[] result = new int[] {};
		for (int i = 0; i < numbers.length; i++) {
			Integer num1 = numbers[i];
			if (num1 > target) break;
			Integer num2 = numMap.get(target - num1);
			if (num2 != null) {
				result = new int[2];
				result[0] = i + 1;
				result[1] = num2 + 1;
				break;
			}
		}
		return result;
	}
	
	// 雙指針法
	public int[] twoSum_2(int[] numbers, int target) {
		int i = 0;
		int j = numbers.length - 1;
		Integer plusResult= null;
		int[] result = new int[] {};
		while (i < j) {
			plusResult = numbers[i] + numbers[j];
			if (plusResult > target) j--;
			else if (plusResult < target) i++;
			else {
				result = new int[2];
				result[0] = i + 1;
				result[1] = j + 1;
				break;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		TwoSumII twoSumII = new TwoSumII();
		int[] result = twoSumII.twoSum_2(new int[] {2, 7, 11, 15}, 17);
		for (int i : result) {
			System.out.println(i);
		}
	}
}
