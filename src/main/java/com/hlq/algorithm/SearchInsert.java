package com.hlq.algorithm;

/**
 * 
 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:

输入: [1,3,5,6], 5
输出: 2
示例 2:

输入: [1,3,5,6], 2
输出: 1
示例 3:

输入: [1,3,5,6], 7
输出: 4
示例 4:

输入: [1,3,5,6], 0
输出: 0
 * @author Ricky
 *
 */
public class SearchInsert {
	// 简单遍历
	public int searchInsert(int[] nums, int target) {
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] >= target)
				return i;
		}
		return len;
	}
	
	// 二分法 
	public int searchInsert_V2(int[] nums, int target) {
		int min = 0;
		int max = nums.length - 1;
		int mid = 0;
		int location = 0;
		while (min <= max) {
			location = (min + max)/2;
			mid = nums[location];
			if (mid == target) return location;
			// 这里的+-1要注意理解
			if (mid > target) {
				max = location - 1;
			} else {
				min = location + 1;
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		SearchInsert searchInsert = new SearchInsert();
		int[] input = new int[] {1,2,2,4}; 
		int target = 5;
		System.out.println(searchInsert.searchInsert(input, target));
		System.out.println(searchInsert.searchInsert_V2(input, target));
	}
}
