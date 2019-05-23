package com.hlq.algorithm;

import java.util.ArrayList;
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
	public List<List<Integer>> permute(int[] nums) {
		int length = nums.length;
		List<List<Integer>> result 
			= new ArrayList<List<Integer>>(length*(length-1));
		
		return null;
	}
}
