package com.hlq.algorithm;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 *
 * 提示：
 *
 *     m == grid.length
 *     n == grid[i].length
 *     1 <= m, n <= 200
 *     0 <= grid[i][j] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MinPathSum {
    static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int n = grid.length ;
        int m = grid[0].length;
        // 动态规划
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j== 0) continue;
                if (i == 0) {
                    grid[0][j] += grid[0][j-1];
                    continue;
                }
                if (j == 0) {
                    grid[i][0] += grid[i-1][0];
                    continue;
                }
                if (grid[i-1][j] > grid[i][j-1]) {
                    grid[i][j] += grid[i][j-1];
                } else {
                    grid[i][j] += grid[i-1][j];
                }
            }
        }
        return grid[n-1][m-1];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{}));
    }
}
