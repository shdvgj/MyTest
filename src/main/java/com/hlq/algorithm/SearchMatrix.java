package com.hlq.algorithm;

/**
 * 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sorted-matrix-search-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class SearchMatrix {
    // 基本思路，从右上角开始遍历，左边是比它小的，下边是比它大的，相当于是一个二叉树遍历
    static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int n = 0;
        int m = matrix[0].length - 1;
        while (true) {
            if (matrix[n][m] == target) return true;
            if (matrix[n][m] > target) m--;
            else n++;
            if (m < 0 || n >= matrix.length) return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{}}, 18));
    }
}
