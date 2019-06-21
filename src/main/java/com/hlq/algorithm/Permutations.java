package com.hlq.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 * @author Ricky
 *
 */
public class Permutations {
	// 使用回溯算法
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> output = new ArrayList<>();
		List<Integer> nums_list = new ArrayList<>();
		for (Integer integer : nums) 
			nums_list.add(integer);
		
		int n = nums.length;
		backTrack(n, nums_list, output, 0);
		return output;
	}
	
	public void backTrack(int n, 
			List<Integer> nums_list, 
			List<List<Integer>> output,
			int first) {
		if (first == n) 
			output.add(new ArrayList<Integer>(nums_list));
		
		for (int i = first; i < n; i++) {
			Collections.swap(nums_list, first, i);
			backTrack(n, nums_list, output, first + 1);
			Collections.swap(nums_list, first, i);
		}
	}
	
	public static void main(String[] args) {
		Permutations permutations = new Permutations();
		List<List<Integer>> result = permutations.permute(new int[] {1,2,3});
		for (List<Integer> list : result) {
			for (Integer integer : list) {
				System.out.print(integer + ",");
			}
			System.out.println("");
		}
	}
}

