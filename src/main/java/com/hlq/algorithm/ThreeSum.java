package com.hlq.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 * @author Ricky
 * TODO 待优化
 */
public class ThreeSum {
	// 基本思路 ， 先将两个数两两相加 ， 得出一个数据集合 ， 再从剩下的数里面找可以=0的数 ，
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			numsMap.put(i, nums[i]);
		}
		// 校验是否重复的map
		Map<String, Integer> noDuplacateMap = new HashMap<String, Integer>();
		Integer num1 = 0, num2 = 0 , leftSum = 0;
		int min = 0, mid = 0 , max = 0;
		String minStr = "", midStr = "", maxStr = "";
		for (int i = 0; i < nums.length; i++) {
			num1 = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				num2 = nums[j];
				leftSum = 0 - num1 - num2;
				numsMap.remove(i);
				numsMap.remove(j);
				// 获取符合要求的数 ， 排除 i和j本身
				if (numsMap.containsValue(leftSum)) {
					min = Math.min(Math.min(num1, num2),leftSum);
					max = Math.max(Math.max(num1, num2),leftSum);
					mid = 0 - min - max;
					minStr = String.valueOf(min);
					midStr = String.valueOf(mid);
					maxStr = String.valueOf(max);
					// 校验是否重复
					if (!noDuplacateMap.containsKey(minStr + midStr + maxStr)) {
						// 将相加的数字排列组合后写入map ， 用于校验重复值
						noDuplacateMap.put(minStr + midStr + maxStr, 0);
						List<Integer> intList = new ArrayList<Integer>();
						intList.add(num1);
						intList.add(num2);
						intList.add(leftSum);
						result.add(intList);
					};
				} else {
					numsMap.put(i, num1);
					numsMap.put(j, num2);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		ThreeSum threeSum = new ThreeSum();
		List<List<Integer>> result = threeSum.threeSum(new int[] {0,0,0,0,0,1,1,-2,-1});
		for (List<Integer> list : result) {
			System.out.println(list.get(0) + "," + list.get(1) + "," + list.get(2));
		}
	}
}
