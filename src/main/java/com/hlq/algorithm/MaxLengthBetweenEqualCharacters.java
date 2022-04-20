package com.hlq.algorithm;

/**
 * 给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
 *
 * 子字符串 是字符串中的一个连续字符序列。

 * 示例 1：
 *
 * 输入：s = "aa"
 * 输出：0
 * 解释：最优的子字符串是两个 'a' 之间的空子字符串。
 *
 * 示例 2：
 *
 * 输入：s = "abca"
 * 输出：2
 * 解释：最优的子字符串是 "bc" 。
 *
 * 示例 3：
 *
 * 输入：s = "cbzxy"
 * 输出：-1
 * 解释：s 中不存在出现出现两次的字符，所以返回 -1 。
 *
 * 示例 4：
 *
 * 输入：s = "cabbac"
 * 输出：4
 * 解释：最优的子字符串是 "abba" ，其他的非最优解包括 "bb" 和 "" 。
 *

 * 提示：
 *
 *     1 <= s.length <= 300
 *     s 只含小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-substring-between-two-equal-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxLengthBetweenEqualCharacters {
    // 基本思路：遍历一遍，时间复杂度O(N)，通过map存储已经存在的字符，在遍历时再次发现该字符的话就把两个位置的值相减并和已存储的最大值进行比较
    /*static int maxLengthBetweenEqualCharacters(String s) {
        if (s == null || s.length() == 0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        char[] characters = s.toCharArray();
        int result = 0;
        int temp;
        char ch;
        for (int i = 0; i < characters.length; i++) {
            ch = characters[i];
            if (map.containsKey(ch)) {
                temp = i - map.get(ch);
                if (temp > result) result = temp;
            } else {
                map.put(ch, i);
            }
        }
        return result - 1;
    }*/

    static int maxLengthBetweenEqualCharacters(String s) {
        // 不使用map的方案
        if (s == null || s.length() == 0) return -1;
        int[] alpha = new int[26];//ASCII字符长度
        char[] characters = s.toCharArray();
        int result = -1;
        int temp;
        int ch;
        for (int i = 0; i < characters.length; i++) {
            ch = characters[i] - 97; // a的ascII位置是97
            if (alpha[ch] > 0) {
                temp = i - alpha[ch];
                if (temp > result) result = temp;
            } else {
                alpha[ch] = i + 1; // int数组默认初始化为0，所以需要通过+1和初始0值进行区分
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxLengthBetweenEqualCharacters("abca"));
//        System.out.println('b' - 0);
    }
}
