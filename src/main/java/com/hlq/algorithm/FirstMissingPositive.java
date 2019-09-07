package com.hlq.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。

 示例 1:

 输入: [1,2,0]
 输出: 3
 示例 2:

 输入: [3,4,-1,1]
 输出: 2
 示例 3:

 输入: [7,8,9,11,12]
 输出: 1
 说明:

 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。

 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        Integer min = null;
        Map<Integer, Integer> intMap = new HashMap<>();
        for (int num : nums) {
            if (num > 0) {
                if (min == null || num < min) min = num;
                intMap.put(num, num + 1);
            }
        }
        if (min == null || min > 1) return 1;
        int temp = min;
        while (intMap.get(temp) != null) {
            temp = intMap.get(temp);
        }
        return temp;
    }

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{3,4,-1,1}));
    }
}
