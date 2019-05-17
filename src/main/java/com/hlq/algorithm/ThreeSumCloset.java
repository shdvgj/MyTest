package com.hlq.algorithm;

import java.util.Arrays;

/**
 * 
 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * @author Ricky
 *
 */
public class ThreeSumCloset {
	// 思路 ： 先对数组进行排序 ， 再确定target在数组中的位置
	// update 思路错误 ， 确定其位置没有软用
    public int threeSumClosest(int[] nums, int target) {
    	// 先进行排序
        Arrays.sort(nums);
        // 二分法查找target的位置
        // 数组的起始位置
        int min = 0;
        // 数组的结束位置
        int max = nums.length - 1;
        // 当前location
        int location = 0;
        while (min <= max) {
        	location = (max + min) / 2;
        	if (nums[location] == target) {
        		break;
        	}else if (nums[location] < target) {
				min = location + 1;
			} else {
				max = location - 1;
			}
        }
    	return location;
    }
    
    // 双指针法
    public int threeSumClosest_V2(int[] nums, int target) {
    	// 排序
        Arrays.sort(nums);
        int closestNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r){
                int threeSum = nums[l] + nums[r] + nums[i];
                if (Math.abs(threeSum - target) < Math.abs(closestNum - target)) {
                    closestNum = threeSum;
                }
                if (threeSum > target) {
                    r--;
                } else if (threeSum < target) {
                    l++;
                } else {
                    // 如果已经等于target的话, 肯定是最接近的
                    return target;
                }

            }

        }
        return closestNum;
    }
    
    // 双指针法
    public int threeSumClosest_V3(int[] nums, int target) {
    	// 排序
        Arrays.sort(nums);
        int closestNum = nums[0] + nums[1] + nums[2];
        int length = nums.length;
        int threeSum = 0;
        for (int i = 0; i < length; i++) {
			int l = i + 1 , r = length - 1;
			while(l < r) {
				threeSum = nums[i] + nums[l] + nums[r];
				if (Math.abs(threeSum - target) < Math.abs(closestNum - target)) {
					closestNum = threeSum;
				}
				if (threeSum > target) {
					r--;
				} else if (threeSum < target) {
					l++;
				} else {
					return closestNum;
				}
			}
		}
        return closestNum;
    }
    
    public static void main(String[] args) {
		ThreeSumCloset threeSumCloset = new ThreeSumCloset();
		System.out.println(threeSumCloset.threeSumClosest_V2(new int[] {-1,0,1,1,55}, 3));
		System.out.println(threeSumCloset.threeSumClosest_V3(new int[] {-1,0,1,1,55}, 3));
	}
}
