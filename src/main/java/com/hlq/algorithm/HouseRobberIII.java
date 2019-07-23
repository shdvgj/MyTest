package com.hlq.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hlq.algorithm.model.TreeNode;

/**
 * 
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，
 * 我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

示例 1:

输入: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \ 
     3   1

输出: 7 
解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
示例 2:

输入: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

输出: 9
解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.

 * @author Ricky
 * TODO
 */
public class HouseRobberIII {
	public int rob(TreeNode root) {
		if (root == null) return 0;
		List<TreeNode> treeNodeList = new ArrayList<>();
		addTreeNodeList(treeNodeList, root);
		treeNodeList.sort((a,b) -> {
			return b.val - a.val;
		});
		int len = treeNodeList.size();
		int max = 0;
		for (int i = 0; i < len; i++) {
			TreeNode first = treeNodeList.get(i);
			Map<TreeNode, Integer> map = new HashMap<>();
			if (first.left != null) map.put(first.left, 0);
			if (first.right != null) map.put(first.right, 0);
			int temp = first.val;
			for (int j = i+1; j < len; j++) {
				TreeNode second = treeNodeList.get(j);
				if (first != second.left && first != second.right 
						&& map.get(second) == null
						&& map.get(second.left) == null
						&& map.get(second.right) == null
						) {
					temp += second.val;
					if (second != null) map.put(second, 0);
					if (second.left != null) map.put(second.left, 0);
					if (second.right != null) map.put(second.right, 0);
				}
			}
			if (temp > max) {
				max = temp;
			}
		}
		return max;
	}
	
	public void addTreeNodeList(List<TreeNode> treeNodeList , TreeNode treeNode) {
		treeNodeList.add(treeNode);
		if (treeNode.left != null) addTreeNodeList(treeNodeList, treeNode.left);
		if (treeNode.right != null) addTreeNodeList(treeNodeList, treeNode.right);
	}
	
	public static void main(String[] args) {
		HouseRobberIII houseRobberIII = new HouseRobberIII();
		TreeNode head = new TreeNode(4);
		head.left = new TreeNode(1);
		head.left.left = new TreeNode(2);
		head.left.left.left = new TreeNode(3);
		System.out.println(houseRobberIII.rob(head));
	}
}
