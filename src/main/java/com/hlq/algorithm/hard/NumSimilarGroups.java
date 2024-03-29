package com.hlq.algorithm.hard;

/**
 * 如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。
 *
 * 例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。
 *
 * 总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同一组中，即使它们并不相似。形
 * 式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。
 *
 * 给定一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个 字母异位词 。请问 strs 中有多少个相似字符串组？
 *
 * 字母异位词（anagram），一种把某个字符串的字母的位置（顺序）加以改换所形成的新词。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["tars","rats","arts","star"]
 * 输出：2
 *
 * 示例 2：
 *
 * 输入：strs = ["omv","ovm"]
 * 输出：1
 *
 *
 *
 * 提示：
 *
 *     1 <= strs.length <= 300
 *     1 <= strs[i].length <= 300
 *     strs[i] 只包含小写字母。
 *     strs 中的所有单词都具有相同的长度，且是彼此的字母异位词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/H6lPxb
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumSimilarGroups {
    int[] connectArr;
    int result;

    public int numSimilarGroups(String[] strs) {
        int len = strs.length;
        result = len;
        connectArr = new int[len];
        connectArr[0] = 1;
        int charLen = strs[0].length();
        for (int i = 0; i < len - 1; i++) {
            char[] chars1 = strs[i].toCharArray();
            out:
            for (int j = i+1; j < len; j++) {
                if (connectArr[j] == 0) connectArr[j] = j+1;
                char[] chars2 = strs[j].toCharArray();
                int diff = 0;
                for (int k = 0; k < charLen; k++) {
                    if (chars1[k] != chars2[k]) diff++;
                    if (diff > 2) continue out;
                }
                union(i, j);
            }
        }
        return result;
    }

    // 连通分量
    void union(int i, int j) {
        int id1 = connectArr[i];
        int id2 = connectArr[j];
        if (id1 == id2) return;
        for (int k = 0; k < connectArr.length; k++) {
            if (connectArr[k] == id2) connectArr[k] = id1;
        }
        result--;
    }

    public static void main(String[] args) {
        NumSimilarGroups numSimilarGroups = new NumSimilarGroups();
        System.out.println(numSimilarGroups.numSimilarGroups(new String[]{"tars","rats","arts","star"}));
    }
}
