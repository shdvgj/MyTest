package com.hlq.algorithm;

/**
 * 给你一个二进制字符串 binary ，它仅有 0 或者 1 组成。你可以使用下面的操作任意次对它进行修改：
 *
 *     操作 1 ：如果二进制串包含子字符串 "00" ，你可以用 "10" 将其替换。
 *         比方说， "00010" -> "10010"
 *     操作 2 ：如果二进制串包含子字符串 "10" ，你可以用 "01" 将其替换。
 *         比方说， "00010" -> "00001"
 *
 * 请你返回执行上述操作任意次以后能得到的 最大二进制字符串 。如果二进制字符串 x 对应的十进制数字大于二进制字符串 y 对应的十进制数字，那么我们称二进制字符串 x 大于二进制字符串 y 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：binary = "000110"
 * 输出："111011"
 * 解释：一个可行的转换为：
 * "000110" -> "000101"
 * "000101" -> "100101"
 * "100101" -> "110101"
 * "110101" -> "110011"
 * "110011" -> "111011"
 *
 * 示例 2：
 *
 * 输入：binary = "01"
 * 输出："01"
 * 解释："01" 没办法进行任何转换。
 *
 *
 *
 * 提示：
 *
 *     1 <= binary.length <= 105
 *     binary 仅包含 '0' 和 '1' 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-string-after-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumBinaryString {
    /**
     * 第一步 从左往右，找到第一个0的位置，记录为zeroIndex
     * 第二步 从zeroIndex往右，找到1之后记录为oneIndex
     * 第三步 oneIndx>0的情况下，指针从右往左找0，找到之后记录为reverseZeroIndex
     * 第四步 将oneIndex和reverseZeroIndex所在的字符互换
     * 第五步 将oneIndex和reverseZeroIndex重置为-1
     * 第六步 指针重新从原来oneIndex的位置向右移动，重复二到五步
     * @param binary
     * @return
     */
    String maximumBinaryString(String binary) {
        if (binary == null || binary.length() <= 1) return binary;
        char[] chars = binary.toCharArray();
        int index;
        int len = chars.length;
        for (int i = 0; i < len;) {
            // 找到第一个0的位置
            if (chars[i++] == '0') {
                // 将第一个0下标+1的位置记录下来
                index = i;
                // i从第一个0的右边开始从左到右遍历，j从右到左遍历
                for (int j = len - 1; j >= i;) {
                    if (chars[i] == '1') {
                        // 将第一个0右边的1全部移到最右侧
                        if (chars[j] == '0') {
                            chars[i] = '0';
                            chars[j] = '1';
                        } else j--;
                    } else i++;
                    // 将左边的00变成10
                    if (chars[index] == '0') {
                        chars[index - 1] = '1';
                        index++;
                    }
                }
                break;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        MaximumBinaryString maximumBinaryString = new MaximumBinaryString();
        System.out.println(maximumBinaryString.maximumBinaryString("00010"));
    }
}
