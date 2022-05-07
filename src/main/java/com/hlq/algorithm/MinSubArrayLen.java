package com.hlq.algorithm;

import java.util.Arrays;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 *
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 *
 *
 * 提示：
 *
 *     1 <= target <= 10^9
 *     1 <= nums.length <= 10^5
 *     1 <= nums[i] <= 10^5
 *
 *
 *
 * 进阶：
 *
 *     如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = nums[0];
        if (sum >= target) return 1;
        int minLen = 0;
        int temp = 1;
        int len = nums.length;
        int left = 0, right = left+1;
        // 拉链法
        while (left < len && left < right) {
            if (sum >= target) {
                if (minLen == 0 || temp < minLen) minLen = temp;
                sum -= nums[left++];
                temp--;
            } else {
                if (right == len) break;
                sum += nums[right++];
                temp++;
            }
        }
        return minLen;
    }
    /*
    // 审题错误，要求的是**大于等于**结果的**最短连续**子数组，以下解法是找到等于结果的最短子数组，依然具有实际意义，因此保留
    int minStep;

    public int minSubArrayLen(int target, int[] nums) {
        Arrays.sort(nums);
        int index;
        int len = nums.length;
        if (target > nums[len - 1]) index = len - 1;
        else if (target < nums[0]) return 0;
        else index = findIndex(nums, target);
        if (nums[index] == target) return 1;
        minStep = 0;
        minStepBackTrack(nums, 0, 0, 0, target, index + 1);
        return minStep;
    }

    // 回溯算法
    void minStepBackTrack(int[] nums, int index, int step, int sum, int target, int maxIndex) {
        if ((minStep != 0 && step >= minStep) || sum > target) return;
        if (sum == target) {
            minStep = step;
            return;
        }
        for (int i = index; i < maxIndex; i++) {
            sum += nums[i];
            minStepBackTrack(nums, i+1, step+1, sum, target, maxIndex);
            sum -= nums[i];
        }

    }


    //二分法查找所在位置
    int findIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while(left < right) {
            int mid = (left + right)/2;
            if (nums[mid] >= target) right = mid;
            else left = mid+1;
        }
        return left;
    }*/

    public static void main(String[] args) {
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        System.out.println(minSubArrayLen.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
