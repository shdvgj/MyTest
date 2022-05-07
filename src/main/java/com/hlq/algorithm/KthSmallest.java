package com.hlq.algorithm;

import java.util.Arrays;

/**
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 *
 * 你必须找到一个内存复杂度优于 O(n2) 的解决方案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * 输出：13
 * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
 *
 * 示例 2：
 *
 * 输入：matrix = [[-5]], k = 1
 * 输出：-5
 *
 *
 *
 * 提示：
 *
 *     n == matrix.length
 *     n == matrix[i].length
 *     1 <= n <= 300
 *     -10^9 <= matrix[i][j] <= 10^9
 *     题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列
 *     1 <= k <= n^2
 *
 *
 *
 * 进阶：
 *
 *     你能否用一个恒定的内存(即 O(1) 内存复杂度)来解决这个问题?
 *     你能在 O(n) 的时间复杂度下解决这个问题吗?这个方法对于面试来说可能太超前了，但是你会发现阅读这篇文章（ this paper ）很有趣。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int[] numArr = new int[len*len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                numArr[i*len + j] = matrix[i][j];
            }
        }
        Arrays.sort(numArr);
        return numArr[k-1];
    }

    // 二分法
    public int kthSmallest_v2(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }


    public static void main(String[] args) {
        KthSmallest kthSmallest = new KthSmallest();
        System.out.println(kthSmallest.kthSmallest_v2(new int[][]{{1,2,2},{2,2,7},{3,4,8}},5));
    }
}
