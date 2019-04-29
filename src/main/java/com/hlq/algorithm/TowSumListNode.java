package com.hlq.algorithm;

import java.util.UUID;

import com.hankcs.hanlp.dependency.nnparser.util.math;
import com.hlq.algorithm.model.ListNode;

/*给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807*/
public class TowSumListNode {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Integer listVal1 = sumListNode(l1, null);
		Integer listVal2 = sumListNode(l2, null);
		Integer finalVal = listVal1 + listVal2;
		return null;
	}
	
	private static Integer sumListNode(ListNode listNode , Integer result) {
		if (result == null) {
			result = listNode.val;
		}
		if (listNode.next != null) {
			result = result + listNode.next.val * 10;
			sumListNode(listNode.next, result);
		}
		return result;
	}
	
	private ListNode createListNode(ListNode listNode , Integer finalResult) {
		// int tenCount = finalResult.
		if (listNode == null) {
			listNode = new ListNode(finalResult);
		}
		return null;
	}
	
	public static void main(String[] args) {
		/*ListNode listNode = new ListNode(2);
		listNode.next = new ListNode(4);
		listNode.next.next = new ListNode(3);
		Integer result = sumListNode(listNode , null);
		System.out.println(result);
		Integer integer = 83;
		System.out.println(Math.pow(10D, integer.toString().length() - 1));
		System.out.println(integer%(Math.pow(10D, integer.toString().length() - 1)));*/
		System.out.println(UUID.randomUUID().toString().substring(0,6));
	}
}


