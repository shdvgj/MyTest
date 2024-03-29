package com.hlq.algorithm;

/**
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 *
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 *
 * 示例 2：
 *
 * 输入：piles = [30,11,23,4,20], h = 5
 * 输出：30
 *
 * 示例 3：
 *
 * 输入：piles = [30,11,23,4,20], h = 6
 * 输出：23
 *
 *
 *
 * 提示：
 *
 *     1 <= piles.length <= 10^4
 *     piles.length <= h <= 10^9
 *     1 <= piles[i] <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/koko-eating-bananas
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinEatingSpeed {
    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了99.72% 的用户
     * 内存消耗：41.8 MB, 在所有 Java 提交中击败了90.54% 的用户
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        int max = 1;
        for (int pile : piles) {
            if (pile > max) max = pile;
        }
        int len = piles.length;
        if (len == h) return max;
        int left = 1, right = max;
        // 二分法查找
        while (left < right) {
            int mid = (left + right) / 2;
            int judge = bigThanTarget(piles, mid, h);
            if (judge <= 0) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    int bigThanTarget(int[] piles, int num, int target) {
        int result = 0;
        for (int i = 0; i < piles.length; i++) {
            // Math.ceil(p / K) = ((p-1) // K) + 1
            result += ((piles[i] - 1)/num) + 1;
            if (result > target) return 1;
        }
        if (result == target) return 0;
        return -1;
    }

    public static void main(String[] args) {
        MinEatingSpeed minEatingSpeed = new MinEatingSpeed();
        System.out.println(minEatingSpeed.minEatingSpeed(new int[]{30,11,23,4,20}, 6));
    }
}
