package com.hlq.algorithm;

import com.hlq.algorithm.model.ListNode;


/**
 * 
 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 * @author Ricky
 *
 */
public class MergeTwoLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		Integer val1 = l1 == null ? null : l1.val;
		Integer val2 = l2 == null ? null : l2.val;
		if (val1 == null && val2 == null) return null;
		ListNode result = new ListNode(0);
		ListNode temp = result;
		if (val1 != null) while (true) {
			// 采取淘汰算法 ， 将v1和v2进行比较，如果v1更小，就将v1写入result，并将v1指向l1的下一个，继续和v2比较
			if (val2 == null || val1 <= val2) {
				temp.val = val1;
				if (l1.next == null) {
					if (val2 != null) {
						temp.next = new ListNode(0);
						temp = temp.next;
					}
					break;
				}
				l1 = l1.next;
				val1 = l1.val;
			} else {
				temp.val = val2;
				if (l2.next == null) {
					val2 = null;
				} else {
					l2 = l2.next;
					val2 = l2.val;
				}
			}
			temp.next = new ListNode(0);
			temp = temp.next;
		}
		while (val2 != null) {
			temp.val = val2;
			if (l2.next == null) break;
			l2 = l2.next;
			val2 = l2.val;
			temp.next = new ListNode(0);
			temp = temp.next;
		}
		return result;
	}
	
	public ListNode mergeTwoLists_V2(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode temp = result;
		while (l1 != null && l2 != null) {
			Integer val1 = l1.val, val2 = l2.val;
			temp.next = new ListNode(0);
			temp = temp.next;
			if (val1 >= val2) {
				temp.val = val2;
				l2 = l2.next;
			} else {
				temp.val = val1;
				l1 = l1.next;
			}
		}
		// l1或l2多出的部分必然比已有的集合要大 ， 因此直接将结果的下一指针指向l1或l2
		if (l1 != null) {
			temp.next = l1;
		}
		if (l2 != null) {
			temp.next = l2;
		}
		return result.next;
	}
	
	public static void main(String[] args) {
		MergeTwoLists mergeTwoLists = new MergeTwoLists();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(1);
		l2.next.next = new ListNode(1);
		l2.next.next.next = new ListNode(5);
		mergeTwoLists.mergeTwoLists_V2(l1, l2);
	}
}
