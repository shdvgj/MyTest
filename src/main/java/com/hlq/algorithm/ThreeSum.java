package com.hlq.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	// 双指针法
	public List<List<Integer>> threeSum_V2(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int threeSum = 0;
		int length = nums.length;
		// 记录上一个成功相加的前两个数
		if (length > 2) {
			int first = nums[0],second = nums[length - 1];
			for (int i = 0; i < length - 2; i++) {
				int l = i + 1 , r = length - 1;
				// 如果首数大于0或者尾数小于0 ， 直接结束循环
				if (nums[i] > 0 || nums[r] < 0) break;
				// 如果首数和上一个首数相同 ， 跳过（原因：避免重复值）
				if (i > 0 && nums[i] == nums[i-1]) continue;
				// 双指针法
				while (l < r) {
					// 如果首数和左数相加大于0，或者右数小于0，结束循环
					if (nums[i] + nums[l] > 0 || nums[r] < 0) break;
					threeSum = nums[i] + nums[l] + nums[r];
					// first和second用于避免重复的三个数相加
					// first和second用于记录上一次加进数组的三个数的头两个数
					// 头两个就可以确定三个数
					// 由于数组经过排序，因此如果在子循环内出现重复值，肯定是和上一个相加的两个数相同
					if (nums[i] == first && nums[l] == second && !result.isEmpty()) {
						// 左值+1，并跳过这次循环
						l++;
						continue;
					}
					if (threeSum == 0) {
						List<Integer> threeSumList = new ArrayList<Integer>();
						threeSumList.add(nums[i]);
						threeSumList.add(nums[l]);
						threeSumList.add(nums[r]);
						result.add(threeSumList);
						// 如果首数是0 ， 直接返回结果
						if (nums[i] == 0) return result;
						first = nums[i];
						second = nums[l];
						r--;
						l++;
					} else if (threeSum > 0) {
						r --;
					} else {
						l ++;
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		ThreeSum threeSum = new ThreeSum();
		List<List<Integer>> result = threeSum.threeSum_V2(new int[] {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0});
		for (List<Integer> list : result) {
			System.out.println(list.get(0) + "," + list.get(1) + "," + list.get(2));
		}
	}
}
