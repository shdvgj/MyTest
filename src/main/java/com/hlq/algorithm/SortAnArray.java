package com.hlq.algorithm;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 *
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *
 *
 *
 * 提示：
 *
 *     1 <= nums.length <= 5 * 10^4
 *     -5 * 10^4 <= nums[i] <= 5 * 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sort-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortAnArray {
    public int[] sortArray(int[] nums) {
//        bubbleSort(nums);
        Arrays.sort(nums);
        return nums;
    }

    // 冒泡排序
    void bubbleSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    switchNum(nums, j, j - 1);
                }
            }
        }
    }

    // 选择排序
    void selectSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minIndex]) minIndex = j;
            }
            switchNum(nums, i, minIndex);
        }
    }

    void switchNum(int[] nums, int n, int m) {
        if (n == m) return;
        int temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
    }
}
