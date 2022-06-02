package com.hlq.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 *
 * 示例 2：
 *
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。
 *
 *
 *
 * 提示：
 *
 *     1 <= nums.length <= 10^5
 *     nums[i] 不是 0 就是 1
 * 0 0 0 1 1 0 0 0 1 1
 * -1 -2 -3 -2 -1 -2 -3 -4 -3 -2
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/A1NYOS
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMaxLength {
    // 超出时间限制
    // 前缀和遍历
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int check = 0;
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            if (check > len - i || check < i - len) break;
            if (max > len - i) break;
            if (nums[i] == 0) check = -1;
            else check = 1;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] == 0) check--;
                else check++;
                if (check == 0 && j - i > max) max = j - i;
                if (check > len - j || check < j - len) break;
            }
        }
        return max > 0 ? max + 1 : max;
    }

    // 前缀和+map
    public int findMaxLength_V2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int check = 0, max = 0, len = nums.length;
        map.put(check, -1);
        for (int i = 0; i < len; i++) {
            if (max >= len - i) break;
            if (nums[i] == 0) check--;
            else check++;
            if (map.containsKey(check)) {
                int between = i - map.get(check);
                if (between > max) max = between;
            } else {
                map.put(check, i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        FindMaxLength findMaxLength = new FindMaxLength();
        System.out.println(findMaxLength.findMaxLength(new int[]{0,1}));
    }

}
