package com.hlq.algorithm;

/**
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 * 示例 2:
 *
 * 输入： s = "God Ding"
 * 输出："doG gniD"
 *
 *
 *
 * 提示：
 *
 *     1 <= s.length <= 5 * 104
 *     s 包含可打印的 ASCII 字符。
 *     s 不包含任何开头或结尾空格。
 *     s 里 至少 有一个词。
 *     s 中的所有单词都用一个空格隔开。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseWordsIII {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int initIndex = 0;
        int len = chars.length;
        for (int i = 1; i < len; i++) {
            // 空格的ASCII值是32
            if (chars[i] == 32 && chars[i-1] != 32) {
                int right = i - 1;
                while (initIndex < right) {
                    char temp = chars[initIndex];
                    chars[initIndex++] = chars[right];
                    chars[right--] = temp;
                }
                initIndex = i;
            } else if (chars[initIndex] == 32) {
                initIndex = i;
            } else if (i == len - 1) {
                int right = i;
                while (initIndex < right) {
                    char temp = chars[initIndex];
                    chars[initIndex++] = chars[right];
                    chars[right--] = temp;
                }
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
       ReverseWordsIII reverseWordsIII = new ReverseWordsIII();
        System.out.println(reverseWordsIII.reverseWords("God Ding"));
    }
}
