package com.hlq.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个字符串 s ，请你拆分该字符串，并返回拆分后唯一子字符串的最大数目。
 *
 * 字符串 s 拆分后可以得到若干 非空子字符串 ，这些子字符串连接后应当能够还原为原字符串。但是拆分出来的每个子字符串都必须是 唯一的 。
 *
 * 注意：子字符串 是字符串中的一个连续字符序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "ababccc"
 * 输出：5
 * 解释：一种最大拆分方法为 ['a', 'b', 'ab', 'c', 'cc'] 。像 ['a', 'b', 'a', 'b', 'c', 'cc'] 这样拆分不满足题目要求，因为其中的 'a' 和 'b' 都出现了不止一次。
 *
 * 示例 2：
 *
 * 输入：s = "aba"
 * 输出：2
 * 解释：一种最大拆分方法为 ['a', 'ba'] 。
 *
 * 示例 3：
 *
 * 输入：s = "aa"
 * 输出：1
 * 解释：无法进一步拆分字符串。
 *
 *
 *
 * 提示：
 *
 *     1 <= s.length <= 16
 *
 *     s 仅包含小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-a-string-into-the-max-number-of-unique-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxUniqueSplit {
    /*static int maxUniqueSplit(String s) {
        char[] chars = s.toCharArray();
        int[][] temp = new int[26][16];//题设仅包含小写英文字母
        int ct = 0;
        int cur = 0;
        int head = 0;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            // a的ASCII字符码是97
            if (head == 0) head = ch - 97;
            if (temp[head][cur] == ch) {
                cur++;
            } else {
                temp[head][cur] = ch;
                head = 0;
                cur = 0;
                ct++;
            }
        }
        return ct;
    }*/
    int ct = 1;
    int length = 1;

    // aac a
    int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>(16);
        length = s.length();
        maxUniqueSplit(0, 0, s, set);
        return ct;
    }

    void maxUniqueSplit(int index, int split, String s, Set<String> set) {
        if (ct < split) ct = split;
        for (int i = index; i < length; i++) {
            if (length - i + split < ct) break;// 关键步骤，判断当前切分数加上剩余数组长度是否大于最大切分数，如果不大于，则没有必要进一步切分
            String substring = s.substring(index, i+1);
            if (set.add(substring)) {
                maxUniqueSplit(i + 1, split + 1, s, set);
                set.remove(substring);
            }
        }
    }

    /*int maxSplit = 1;
    void backtrack(int index, int split, String s, Set<String> set) {
        int length = s.length();
        if (index >= length) {
            maxSplit = Math.max(maxSplit, split);
        } else {
            for (int i = index; i < length; i++) {
                String substr = s.substring(index, i + 1);
                if (set.add(substr)) {
                    backtrack(i + 1, split + 1, s, set);
                    set.remove(substr);
                }
            }
        }
    }*/

    int count=0;
    char[] arr;
    Set<String> lookUp;
    public int maxUniqueSplit_2(String s) {
        arr=s.toCharArray();
        lookUp=new HashSet<>();
        dfs(0,0,arr,s.length());
        return count;
    }

    private void dfs(int begin,int cur_depth,char[] arr,int remain_length){
        if(remain_length==0){
            count=Math.max(cur_depth,count);
            return;
        }
        for(int start=begin,end=begin;end<arr.length;end++){
            int left_length=arr.length-end-1;
            if(cur_depth+1+left_length<=count)
                break;
            String temp=new String(arr,start,end-start+1);
            if(lookUp.contains(temp))
                continue;

            lookUp.add(temp);
            dfs(end+1,cur_depth+1,arr,left_length);
            lookUp.remove(temp);
        }

    }


    public static void main(String[] args) {
        MaxUniqueSplit maxUniqueSplit = new MaxUniqueSplit();
        System.out.println(maxUniqueSplit.maxUniqueSplit("gpaccacseleac"));
//        System.out.println(maxUniqueSplit("gpaccacseleac"));
        // g p a c ca cs e l eac
        // ccacs
        // g p a cc ac s e l ea c
        // c a e l es ca cc ap g
    }
}
