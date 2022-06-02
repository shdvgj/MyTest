package com.hlq.algorithm;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 给你一个列表 nums ，里面每一个元素都是一个整数列表。请你依照下面各图的规则，按顺序返回 nums 中对角线上的整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,4,2,7,5,3,8,6,9]
 *
 * 示例 2：
 *
 * 输入：nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
 * 输出：[1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
 *
 * 示例 3：
 *
 * 输入：nums = [[1,2,3],[4],[5,6,7],[8],[9,10,11]]
 * 输出：[1,4,2,5,3,8,6,9,7,10,11]
 *
 * 示例 4：
 *
 * 输入：nums = [[1,2,3,4,5,6]]
 * 输出：[1,2,3,4,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/diagonal-traverse-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindDiagonalOrder {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int len = nums.size();
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            // 获取最大长度
            if (nums.get(i).size() > maxLen) maxLen = nums.get(i).size();
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = i, k = 0; j >= 0; j--, k++) {
                if (k == maxLen) break;
                if (k < nums.get(j).size()) {
                    result.add(nums.get(j).get(k));
                }
            }
        }
        for (int i = 1; i < maxLen; i++) {
            for (int j = i, k = len - 1; k >= 0; j++, k--) {
                if (j == maxLen) break;
                if (j < nums.get(k).size()) {
                    result.add(nums.get(k).get(j));
                }
            }
        }
        int arrLen = result.size();
        int[] arr = new int[arrLen];
        for (int i = 0; i < arrLen; i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    /**
     * 不难发现，处于对角线的数字其坐标相加是相等的，根据这个原理存入list，然后再按照顺序遍历list即可
     * @param nums
     * @return
     */
    public int[] findDiagonalOrder_V2(List<List<Integer>> nums) {
        int len = nums.size();
        List<List<Integer>> list = new ArrayList<>();
        int size = 0;
        for (int i = 0; i < len; i++) {
            List<Integer> inList = nums.get(i);
            for (int j = 0; j < inList.size(); j++) {
                List<Integer> resultList;
                if (i + j < list.size()) {
                    resultList = list.get(i+j);
                    resultList.add(inList.get(j));
                } else {
                    resultList = new ArrayList<>();
                    resultList.add(inList.get(j));
                    list.add(resultList);
                }
                size++;
            }
        }
        int[] arr = new int[size];
        int arrIndex = 0;
        int index = 0;
        while (index < list.size()) {
            List<Integer> inList = list.get(index++);
            for (int i = inList.size() - 1; i >= 0; i--) {
                arr[arrIndex++] = inList.get(i);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        List<List<Integer>> params = new ArrayList<>();
        params.add(Arrays.asList(1,2,3));
        params.add(Arrays.asList(4,5,6));
        params.add(Arrays.asList(7,8,9));
        FindDiagonalOrder findDiagonalOrder = new FindDiagonalOrder();
        System.out.println(findDiagonalOrder.findDiagonalOrder_V2(params));
    }

}
