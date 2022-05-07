package com.hlq.algorithm;

/**
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 *
 * 示例1:
 *
 *  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 *  输出：-1
 *  说明: 不存在返回-1。
 *
 * 示例2:
 *
 *  输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 *  输出：4
 *
 * 提示:
 *
 *     words的长度在[1, 1000000]之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sparse-array-search-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindString {
    public int findString(String[] words, String s) {
        char[] chars1 = s.toCharArray();
        int len = chars1.length;
        // 用于在首字母相同的情况下，不再从0开始遍历字符串
        int index = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (len != word.length()) continue;
            char[] chars2 = word.toCharArray();
            if (chars1[0] != chars2[0]) {
                if (index > 0) break;//说明首字母相同的已经比较过，后续都是不同的，可以直接跳出
                continue;
            }
            for (int j = index; j < len; j++) {
                if (chars2[index] == chars1[index]) index++;
                else break;
                if (index == len) return i;
            }
        }
        return -1;
    }

    // 二分法 TODO
    /*public int findString_v2(String[] words, String s) {
        char[] chars1 = s.toCharArray();
        int len = chars1.length;
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = (left + right)/2;
            while (words[mid].length() == 0 && mid < right) mid++;
        }

        return -1;
    }*/
}
