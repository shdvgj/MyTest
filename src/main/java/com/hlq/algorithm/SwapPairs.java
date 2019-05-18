package com.hlq.algorithm;

import com.hlq.algorithm.model.ListNode;

/**
 * 
 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.
 * @author Ricky
 *
 */
public class SwapPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) return head;
		// 返回的结果
		ListNode result = new ListNode(0);
		// 临时变量指向结果 ， 用于指向next
		ListNode resultTemp = result;
		while (true) {
			// 获取到2
			ListNode inTemp = head.next;
			// 交换listNode的指向
			// 1->2  变为 1
			head.next = inTemp.next;
			// 2 变为 2->1
			inTemp.next = head;
			resultTemp.next = inTemp;
			resultTemp = resultTemp.next.next;
			if (head.next == null) break;
			head = head.next;
			if (head.next == null) break;
		}
		return result.next;
	}
	
	public static void main(String[] args) {
		SwapPairs swapPairs = new SwapPairs();
		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(2);
		//listNode.next.next = new ListNode(3);
		//listNode.next.next.next = new ListNode(4);
		ListNode result = swapPairs.swapPairs(listNode);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
		
	}
}
