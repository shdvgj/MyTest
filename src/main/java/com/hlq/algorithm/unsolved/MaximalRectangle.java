package com.hlq.algorithm.unsolved;

/**
 * 给定一个由 0 和 1 组成的矩阵 matrix ，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 注意：此题 matrix 输入格式为一维 01 字符串数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = ["10100","10111","11111","10010"]
 * 输出：6
 * 解释：最大矩形如上图所示。
 *
 * 示例 2：
 *
 * 输入：matrix = []
 * 输出：0
 *
 * 示例 3：
 *
 * 输入：matrix = ["0"]
 * 输出：0
 *
 * 示例 4：
 *
 * 输入：matrix = ["1"]
 * 输出：1
 *
 * 示例 5：
 *
 * 输入：matrix = ["00"]
 * 输出：0
 *
 *
 *
 * 提示：
 *
 *     rows == matrix.length
 *     cols == matrix[0].length
 *     0 <= row, cols <= 200
 *     matrix[i][j] 为 '0' 或 '1'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/PLYXKQ
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximalRectangle {
    public int maximalRectangle(String[] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length();
        int[][] colSum = new int[rowLen][colLen];
        int[][] rowSum = new int[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            String line = matrix[i];
            char[] lineChars = line.toCharArray();
            for (int j = 0; j < colLen; j++) {
                char ch = lineChars[j];
                if (ch == '1') {
                    if (j > 0) colSum[i][j] = colSum[i][j-1] + 1;
                    else colSum[i][j] = 1;
                    if (i > 0) rowSum[i][j] = rowSum[i-1][j] + 1;
                    else rowSum[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        System.out.println(maximalRectangle.maximalRectangle(new String[]{"10100","10111","11111","10010"}));
    }
}
