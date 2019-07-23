package com.hlq.algorithm;

/**
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。
 * 设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。

注意：n 的值小于15000。

示例1:

输入: [1, 2, 3, 4]

输出: False

解释: 序列中不存在132模式的子序列。
示例 2:

输入: [3, 1, 4, 2]

输出: True

解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
示例 3:

输入: [-1, 3, 2, 0]

输出: True

解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].

 * @author Ricky
 *
 */
public class Find132pattern {
	// 方法1：暴力法
	public boolean find132pattern(int[] nums) {
		int len = nums.length;
		for (int i = 0; i < len - 2; i++) {
			int num1 = nums[i];
			for (int j = i+1; j < len - 1; j++) {
				int num2 = nums[j];
				for (int k = j+1; k < len; k++) {
					int num3 = nums[k];
					if (num3 > num1 && num3 < num2 && num2 > num1) return true;
				}
			}
		}
		return false;
	}
	// 方法2
	public boolean find132pattern_2(int[] nums) {
		if (nums == null || nums.length == 0) return false;
		int leftMin = nums[0];
		int right = 0;
		for (int i = 1; i < nums.length - 1; i++) {
			// 獲取當中的數字
			int num2 = nums[i];
			if (leftMin > nums[i-1]) leftMin = nums[i-1];
			if (leftMin > num2) continue;
			for (int j = i + 1; j < nums.length; j++) {
				right = nums[j];
				if (right < num2 && right > leftMin) return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Find132pattern find132pattern = new Find132pattern();
		System.out.println(find132pattern.find132pattern_2(new int[] {1,3,4}));
	}
}
