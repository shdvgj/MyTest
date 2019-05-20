package com.hlq.algorithm;

/**
 * 
 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 * @author Ricky
 * TODO
 */
public class NextPermutation {
	public void nextPermutation(int[] nums) {
		int length = nums.length;
		// 查找下一个更大的数
		for (int i = length - 1; i >= 1; i--) {
			int num1 = nums[i];
			for (int j = i-1; j >= 0; j--) {
				int num2 = nums[j];
				if (num1 > num2) {
					// 把更大的数插入到指定位置
					nums[j] = num1;
					// 同时将指定位置往后的所有数向后挪一位
					for (int k = length - 1; k > j + 1; k--) {
						nums[k] = nums[k - 1];
					}
					nums[j + 1] = num2;
					return;
				}
			}
		}
		// 冒泡排序
		for (int i = 0; i < length; i++) {
			for (int j = length - 1; j > i; j--) {
				int sortNum1 = nums[j];
				int sortNum2 = nums[j-1];
				if (sortNum1 < sortNum2) {
					nums[j] = sortNum2;
					nums[j-1] = sortNum1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		NextPermutation nextPermutation = new NextPermutation();
		int[] nums = new int[] {3,2,3};
		nextPermutation.nextPermutation(nums);
		for (int i : nums) {
			System.out.println(i);
		}
		
	}
}
