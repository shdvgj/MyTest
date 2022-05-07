package com.hlq.algorithm.unsolved;

/**
 * 求出大于或等于 N 的最小回文素数。
 *
 * 回顾一下，如果一个数大于 1，且其因数只有 1 和它自身，那么这个数是素数。
 *
 * 例如，2，3，5，7，11 以及 13 是素数。
 *
 * 回顾一下，如果一个数从左往右读与从右往左读是一样的，那么这个数是回文数。
 *
 * 例如，12321 是回文数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：6
 * 输出：7
 *
 * 示例 2：
 *
 * 输入：8
 * 输出：11
 *
 * 示例 3：
 *
 * 输入：13
 * 输出：101
 *
 *
 *
 * 提示：
 *
 *     1 <= N <= 10^8
 *     答案肯定存在，且小于 2 * 10^8。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/prime-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PrimePalindrome {
    public int primePalindrome(int n) {
        if (n < 10) {
            switch (n) {
                case 1:
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                case 5:
                    return 5;
                case 6:
                case 7:
                    return 7;
            }
        }
        // 查找最近回文
        int closestNum = closestPalindrome(n - 1);
        int sqrt = (int)Math.sqrt(closestNum) + 1;
        int temp = 3;
        while (true) {
            if (closestNum % temp == 0) {
                // 合数则继续寻找最近回文
                closestNum = closestPalindrome(closestNum);
                // 判断n是否是素数的方法，取比n的平方根大的最小整数m，在比m小的整数范围内查找素数，看是否可以和n除尽
                sqrt = (int)Math.sqrt(closestNum);
                temp = 3;
            } else {
                // 不可以除尽，找下一个可能除尽的数
                temp = closestPrime(temp);
                if (temp > sqrt) break;
            }
        }
        return closestNum;
    }

    // 查找最近可能的质数回文
    int closestPalindrome(int num) {
        num++;
        char[] chars = String.valueOf(num).toCharArray();
        int right = chars.length - 1;
        for (int i = 0, j = right; i < j; ) {
            if (chars[i] != chars[j]) {
                chars[j] = chars[i];
                int temp = j-1;
                while (temp > i) {
                    if (chars[temp] != '9') {
                        chars[temp]++;
                    } else temp --;
                }
                break;
            }
            i++;
            j--;
        }
        return Integer.valueOf(new String(chars));
    }

    // 查找最近的可能素数，末尾是1，3，7，9的数字才有可能是素数
    int closestPrime(int num) {
        int last = num % 10;
        switch (last) {
            case 0:
                return num + 1;
            case 1:
                return num + 2;
            case 2:
                return num + 1;
            case 3:
                return num + 4;
            case 4:
                return num + 3;
            case 5:
                return num + 2;
            case 6:
                return num + 1;
            case 7:
                return num + 2;
            case 8:
                return num + 1;
            default:
                return num + 2;

        }
    }

    public static void main(String[] args) {
        PrimePalindrome primePalindrome = new PrimePalindrome();
        System.out.println(primePalindrome.primePalindrome(13));
    }
}
