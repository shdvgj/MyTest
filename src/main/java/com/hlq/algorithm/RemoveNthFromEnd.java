package com.hlq.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.hlq.algorithm.model.ListNode;

/**
 * 
 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？
 * @author Ricky
 *
 */
public class RemoveNthFromEnd {
	// 基本思路 ， 将每个next的listNode存入ArrayList ， 这样每个next就有了下标
	// 最后改变head的指针即可
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// end 指向 head
		ListNode endNode = head;
		List<ListNode> endNodesList = new ArrayList<ListNode>();
		// 存入每个索引位置的listnode
		while (endNode != null) {
			endNodesList.add(endNode);
			endNode = endNode.next;
		}
		int length = endNodesList.size();
		int headNum = length - n - 1;
		int endNum = length - n + 1;
		if (length == 1) {
			return null;
		} else if (n == 1) {
			endNodesList.get(headNum).next = null;
		} else if (n == length) {
			return endNodesList.get(endNum);
		} else {
			// 将首尾拼接
			endNodesList.get(headNum).next = endNodesList.get(endNum);
		}
		return head;
	}
	
	// 思路二，将每个listnode对应的值存入到数组中
	public ListNode removeNthFromEnd_V2(ListNode head, int n) {
		List<Integer> headValList = new ArrayList<Integer>();
		while(head != null) {
			headValList.add(head.val);
			head = head.next;
		}
		if (headValList.isEmpty()) {
			return null;
		}
		ListNode result = null;
		ListNode temp = null;
		int length = headValList.size();
		for (int i = 0; i < length; i++) {
			if (i == length - n) continue;
			if (result == null) {
				result = new ListNode(headValList.get(i));
				temp = result;
				continue;
			}
			temp.next = new ListNode(headValList.get(i));
			temp = temp.next;
		}
		return result;
	}
	
	public static void main(String[] args) {
		RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(3);
		listNode.next.next.next = new ListNode(4);
		listNode.next.next.next.next = new ListNode(5);
		ListNode result = removeNthFromEnd.removeNthFromEnd(listNode, 2);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
		
	}
}
