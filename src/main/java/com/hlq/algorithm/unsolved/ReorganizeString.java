package com.hlq.algorithm.unsolved;

import java.util.Arrays;

/**
 * 给定一个字符串 s ，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 返回 s 的任意可能的重新排列。若不可行，返回空字符串 "" 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "aab"
 * 输出: "aba"
 *
 * 示例 2:
 *
 * 输入: s = "aaab"
 * 输出: ""
 *
 * aababab
 * abababa
 *
 * 提示:
 *
 *     1 <= s.length <= 500
 *     s 只包含小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reorganize-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReorganizeString {
    public String reorganizeString(String s) {
        int len = s.length();
        int[] charArr = new int[27];
        for (int i = 0; i < len; i++) {
            charArr[s.charAt(i) - 96]++;
        }
        char[] newCh = new char[len];
        int[] copyCh = Arrays.copyOf(charArr, 27);
        int index = 0;
        int idx1 = findMax(copyCh);
        int num1 = charArr[idx1];
        int idx2 = findMax(copyCh);
        int num2 = charArr[idx2];
        while (true) {
            if (num1 > 0 && num1 >= num2) {
                newCh[index++] = (char)(idx1 + 96);
                num1--;
                if (num1 == 0) {
                    idx1 = findMax(copyCh);
                    num1 = charArr[idx1];
                }
            } else if (num2 > 1) break;

            if (num2 > 0) {
                newCh[index++] = (char)(idx2 + 96);
                num2--;
                if (num2 == 0) {
                    idx2 = findMax(copyCh);
                    num2 = charArr[idx2];
                }
            } else if (num1 > 1) break;
            if (num1 == 0 && num2 == 0) break;
        }
        if (index != len) return "";
        return new String(newCh);
    }

    private int findMax(int[] copyCh) {
        int maxIndex = 0;
        for (int i = 0; i < copyCh.length; i++) {
            if (copyCh[i] > copyCh[maxIndex]) maxIndex = i;
        }
        if (maxIndex > 0) copyCh[maxIndex] = 0;
        return maxIndex;
    }


    public static void main(String[] args) {
        ReorganizeString reorganizeString = new ReorganizeString();
        System.out.println(reorganizeString.reorganizeString("accdduuaaa"));
        // acacadaudu
    }
}
