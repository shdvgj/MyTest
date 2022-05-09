package com.hlq.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于  n 的 最简 分数 。分数可以以 任意 顺序返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：["1/2"]
 * 解释："1/2" 是唯一一个分母小于等于 2 的最简分数。
 *
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：["1/2","1/3","2/3"]
 *
 * 示例 3：
 *
 * 输入：n = 4
 * 输出：["1/2","1/3","1/4","2/3","3/4"]
 * 解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。
 *
 * 示例 4：
 *
 * 输入：n = 1
 * 输出：[]
 *
 *
 *
 * 提示：
 *
 *     1 <= n <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/simplified-fractions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SimplifiedFractions {
    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();
        if (n == 1) return result;
        for (int i = 2; i <= n; i++) {
            result.add("1/" + i);
            for (int j = 2; j < i; j++) {
                if (check(i,j)) result.add(j + "/" + i);
            }
        }
        return result;
    }

    /*// 判断两个数是否可以构成最简分数
    private boolean check(int i, int j) {
        if (i % j == 0) return false;
        // 判断方法，找出除数的所有可能因数，将其与除数和被除数相除，如果都为0，说明两个数存在共同因数，不是最简分数
        int num = i/2;
        for (int m = 2; m < num; ) {
            if (i % m == 0 && j % m == 0) return false;
            if (m != 9) m++;
            else m += 2;
        }
        return true;
    }*/

    // 判断两个数是否可以构成最简分数
    private boolean check(int i, int j) {
        while (i % j != 0) {
            int temp = i % j;
            i = j;
            j = temp;
            if (j == 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SimplifiedFractions simplifiedFractions = new SimplifiedFractions();
        System.out.println(simplifiedFractions.simplifiedFractions(6));
    }
}
