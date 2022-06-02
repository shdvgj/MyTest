package com.hlq.algorithm;

/**
 * 给定一个表示数据的整数数组 data ，返回它是否为有效的 UTF-8 编码。
 *
 * UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
 *
 *     对于 1 字节 的字符，字节的第一位设为 0 ，后面 7 位为这个符号的 unicode 码。
 *     对于 n 字节 的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为 0 ，后面字节的前两位一律设为 10 。剩下的没有提及的二进制位，全部为这个符号的 unicode 码。
 *
 * 这是 UTF-8 编码的工作方式：
 *
 *       Number of Bytes  |        UTF-8 octet sequence
 *                        |              (binary)
 *    --------------------+---------------------------------------------
 *             1          | 0xxxxxxx
 *             2          | 110xxxxx 10xxxxxx
 *             3          | 1110xxxx 10xxxxxx 10xxxxxx
 *             4          | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 *
 * x 表示二进制形式的一位，可以是 0 或 1。
 *
 * 注意：输入是整数数组。只有每个整数的 最低 8 个有效位 用来存储数据。这意味着每个整数只表示 1 字节的数据。
 *
 *
 *
 * 示例 1：
 *
 * 输入：data = [197,130,1]
 * 输出：true
 * 解释：数据表示字节序列:11000101 10000010 00000001。
 * 这是有效的 utf-8 编码，为一个 2 字节字符，跟着一个 1 字节字符。
 *
 * 示例 2：
 *
 * 输入：data = [235,140,4]
 * 输出：false
 * 解释：数据表示 8 位的序列: 11101011 10001100 00000100.
 * 前 3 位都是 1 ，第 4 位为 0 表示它是一个 3 字节字符。
 * 下一个字节是开头为 10 的延续字节，这是正确的。
 * 但第二个延续字节不以 10 开头，所以是不符合规则的。
 *
 *
 *
 * 提示:
 *
 *     1 <= data.length <= 2 * 104
 *     0 <= data[i] <= 255
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/utf-8-validation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidUtf8 {
    // 找到0000000,10000000,11000000,11100000,11110000,11111000所代表的数字
    // 0, 128, 192, 224, 240, 248
    public boolean validUtf8(int[] data) {
        int len = data.length;
        for (int i = 0; i < len; ) {
            int num = data[i];
            if (num < 128) {
                i++;
                continue;
            }
            if (num < 192) return false;
            if (num < 224) {
                if (i + 1 < len && judge(data, i, 1)) {
                    i += 2;
                    continue;
                } else return false;
            }
            if (num < 240) {
                if (i + 2 < len && judge(data, i, 2)) {
                    i += 3;
                    continue;
                } else return false;
            }
            if (num < 248) {
                if (i + 3 < len && judge(data, i, 3)) {
                    i += 4;
                    continue;
                } else return false;
            }
            return false;
        }
        return true;
    }

    private boolean judge(int[] data, int num, int forNum) {
        for (int i = 1; i <= forNum; i++) {
            if (data[num + i] < 128 || data[num + i] >= 192) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(248));
    }
}
