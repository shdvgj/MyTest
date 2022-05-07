package com.hlq.algorithm;

/**
 * 给定一个数组 coordinates ，其中 coordinates[i] = [x, y] ， [x, y] 表示横坐标为 x、纵坐标为 y 的点。请你来判断，这些点是否在该坐标系中属于同一条直线上。
 *
 *
 *
 * 示例 1：
 *
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * 输出：false
 *
 *
 *
 * 提示：
 *
 *     2 <= coordinates.length <= 1000
 *     coordinates[i].length == 2
 *     -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 *     coordinates 中不含重复的点
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-it-is-a-straight-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckStraightLine {
    public boolean  checkStraightLine(int[][] coordinates) {
        int len = coordinates.length;
        int x = coordinates[0][0];
        int y = coordinates[0][1];
        if (coordinates[1][0] - coordinates[0][0] == 0) {
            // 竖线
            for (int i = 2; i < len; i++) {
                if (coordinates[i][0] != x) return false;
            }
        } else if (coordinates[1][1] - coordinates[0][1] == 0) {
            // 横线
            for (int i = 2; i < len; i++) {
                if (coordinates[i][1] != y) return false;
            }
        } else {
            double rate = (coordinates[1][0] - coordinates[0][0])/(double)(coordinates[1][1] - coordinates[0][1]);
            for (int i = 2; i < len; i++) {
                if ((coordinates[i][0] - x)/(double)(coordinates[i][1]-y) != rate) return false;
            }
        }
        return true;
    }


}
