package com.hlq.algorithm;


import com.hlq.algorithm.model.TreeNode;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 *
 * 示例 2：
 *
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 *
 *
 *
 *
 *
 * 提示：
 *
 *     树中的节点数为 n 。
 *     1 <= k <= n <= 10^4
 *     0 <= Node.val <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KthSmallestElementInABst {
    int n, result;
    public int kthSmallest(TreeNode root, int k) {
        n = 0;
        dfs(root, k);
        return result;
    }

    public void dfs(TreeNode node, int k) {
        if (node == null || n == k) return;
        dfs(node.left, k);
        n++;
        if (n == k) result = node.val;
        dfs(node.right, k);
    }
}
