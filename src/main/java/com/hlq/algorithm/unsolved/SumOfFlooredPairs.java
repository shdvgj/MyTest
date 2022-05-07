package com.hlq.algorithm.unsolved;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，请你返回所有下标对 0 <= i, j < nums.length 的 floor(nums[i] / nums[j]) 结果之和。由于答案可能会很大，请你返回答案对10^9 + 7 取余 的结果。
 *
 * 函数 floor() 返回输入数字的整数部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,5,9]
 * 输出：10
 * 解释：
 * floor(2 / 5) = floor(2 / 9) = floor(5 / 9) = 0
 * floor(2 / 2) = floor(5 / 5) = floor(9 / 9) = 1
 * floor(5 / 2) = 2
 * floor(9 / 2) = 4
 * floor(9 / 5) = 1
 * 我们计算每一个数对商向下取整的结果并求和得到 10 。
 *
 * 示例 2：
 *
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：49
 *
 *
 *
 * 提示：
 *
 *     1 <= nums.length <= 10^5
 *     1 <= nums[i] <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-floored-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumOfFlooredPairs {
    // 暴力法
    public int sumOfFlooredPairs(int[] nums) {
        // 如果是按顺序的数组，将会大大简化算法，因此先进行排序
        int len = nums.length;
        Arrays.sort(nums);
        //题设 1<= nums[i]<=10^5 排除0和小数的情况
        double result = len;
        for (int j = len - 1; j > 0; j--) {
            for (int k = j - 1; k >= 0; k--) {
                if (nums[j] == nums[k]) result += 2;
                else result += nums[j] / nums[k];
            }
        }
        result = result%(1000000007);
        return (int)result;
    }

    // 二分法，思路，由于是相除之后得到的结果相加，因此可以通过当前数值的倍数，比如1的两倍是2，在数组中找到小于等于2的索引位置，索引位置减去1所在的位置*倍数就可以直接加到结果里
    public int sumOfFlooredPairs_V2(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        //题设 1<= nums[i]<=10^5 排除0和小数的情况
        double result = len;
        int right = len - 1;
        int maxIndex, minIndex;
        for (int i = 0; i < len; i++) {
            maxIndex = 0;
            for (int j = 1; nums[i] * j < nums[right]; j++) {
                int temp = nums[i] * j;
                minIndex = twoDevoiceFindMin(nums, temp, i + maxIndex, right);
                maxIndex = twoDevoiceFindMax(nums, temp, i + maxIndex, right);
                if (minIndex > maxIndex) maxIndex = minIndex;
                if (nums[maxIndex] == temp) {
                    result += (maxIndex - minIndex) * j + (minIndex - i) * (j-1);
                } else if (nums[maxIndex] < temp) {
                    result += (maxIndex - i) * (j - 1);
                } else {
                    result += nums[maxIndex]/nums[i];
                }
            }
        }
        return (int)result%(1000000007);
    }

    int twoDevoiceFindMin(int[] nums, int target, int left, int right) {
        int minIndex;
        while (left < right) {
            minIndex = (left + right) / 2;
            if (nums[minIndex] >= target) {
                right = minIndex;
            } else {
                left = minIndex + 1;
            }
        }
        return left;
    }

    int twoDevoiceFindMax(int[] nums, int target, int left, int right) {
        int maxIndex;
        while (left < right) {
            maxIndex = (left + right + 1) / 2;
            if (nums[maxIndex] <= target) {
                left = maxIndex;
            } else right = maxIndex - 1;
        }
        return right;
    }


    public static void main(String[] args) {
        // 9,8,7,6,5,4,3,2,1
        SumOfFlooredPairs sumOfFlooredPairs = new SumOfFlooredPairs();
        /*System.out.println(sumOfFlooredPairs.twoDevoiceFindMax(new int[]{2,5,5,9}, 5, 0, 3));
        System.out.println(sumOfFlooredPairs.twoDevoiceFindMin(new int[]{2,5,5,9}, 5, 0, 3));*/
        System.out.println(sumOfFlooredPairs.sumOfFlooredPairs_V2(new int[]{2,5,9}));
    }
}
