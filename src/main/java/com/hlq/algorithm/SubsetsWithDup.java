package com.hlq.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

 说明：解集不能包含重复的子集。

 示例:

 输入: [1,2,2]
 输出:
 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
public class SubsetsWithDup {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        return result;
    }

    public void addNumList(int[] nums , int index) {
        for(int i = index ; i < nums.length ; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1)
                addNumList(nums , i+1);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        subsetsWithDup.addNumList(new int[]{1,2,2},0);
    }
}
