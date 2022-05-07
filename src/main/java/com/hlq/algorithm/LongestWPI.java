package com.hlq.algorithm;

/**
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 *
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 *
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 *
 * 请你返回「表现良好时间段」的最大长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：hours = [6,9,9,6,0,6,6,9,9,9,9]
 *      hours = [-1,1,1,-1,-1,-1,-1,1,1,1,1]
 *      hours = [-1,0,1,0,-1,-2,-3,-2,-1,0,1]
 *      hours = [0,1,2,-1,0,0,0,1,2,3,4]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 *
 * 示例 2：
 *
 * 输入：hours = [6,6,6]
 * 输出：0
 *
 *
 *
 * 提示：
 *
 *     1 <= hours.length <= 10^4
 *     0 <= hours[i] <= 16
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-well-performing-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestWPI {
    // 动态规划
    public int longestWPI(int[] hours) {
        int len = hours.length;
        int max = 0;
        int tempMax = 0;
        for (int i = 0; i < len; i++) {
            int temp = 0;
            for (int j = i; j < len; j++) {
                if (hours[j] > 8) temp++;
                else temp--;
                if (temp > 0) {
                    tempMax = j - i + 1;
                    if (tempMax > max) max = tempMax;
                }
            }
            if (max > len - i) break;
        }
        return max;
    }

    public static void main(String[] args) {
        LongestWPI longestWPI = new LongestWPI();
        System.out.println(longestWPI.longestWPI(new int[]{9,9,6,0,6,6,9}));
    }
}
