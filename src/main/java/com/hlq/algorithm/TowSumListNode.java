package com.hlq.algorithm;

import java.math.BigDecimal;

import com.hlq.algorithm.model.ListNode;

/*给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807*/
public class TowSumListNode {
	
	/**
	 * v1.0 将每个节点内的数字组合成一个数字 ， 然后两个list进行相加 ， 得出结果 ， 再将结果转为listNode
	 * 效率一般 ， 代码太多 ， 且出现了暂时无法解决的问题 ， 废弃 。 
	 * **/
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Double listVal1 = sumListNode(l1);
		Double listVal2 = sumListNode(l2);
		Double finalVal = listVal1 + listVal2;
		return createListNode(finalVal);
	}
	
	private Double sumListNode(ListNode listNode) {
		Double result = 0D;
		for (int i = 0; listNode != null; i++, listNode = listNode.next) {
			result = result + listNode.val * Math.pow(10D, i);
		}
		return result;
	}
	
	// 将加起来后的数字转为listnode，无法解当将字符转为数字时，double内会带有小数点的情况
	private ListNode createListNode(Double finalResult) {
		ListNode listNode = null;
		ListNode nexNode = null;
		String resultStr = finalResult.toString();
		int i = resultStr.length();
		while (i > 0) {
			i--;
			Character node = resultStr.charAt(i);
			if (listNode == null) {
				listNode = new ListNode(Integer.parseInt(node.toString()));
				listNode.next = new ListNode(0);
				nexNode = listNode.next;
			} else {
				nexNode.val = Integer.parseInt(node.toString());
				if (i != 0) {
					nexNode.next = new ListNode(0);
					nexNode = nexNode.next;
				}
			}
		}
		return listNode;
	}
	
	/******************************v1.0 end**************************************/
	
	
	/**
	 * 升级版本 ， 模拟加法运算的方式 ， 每一位单独进行相加
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers_v2(ListNode l1, ListNode l2) {
		Integer p , q , sum , num , carry = 0;
		ListNode result = new ListNode(0);
		// 设置一个临时的变量来指向返回的result ， 这个临时变量来实现不断的next
		ListNode temp = result;
		do {
			p = l1.val;
			q = l2.val;
			sum = p + q + carry;
			// 得到除以10的余数
			num = sum % 10;
			temp.val = num;
			// 是否进位 0否 ， 1是
			carry = sum >= 10 ? 1 : 0;
			if (l1.next == null && l2.next == null) {
				break;
			} else {
				// 关键的步骤 ， 在一个循环结束的时候将temp指向next
				temp.next = new ListNode(0);
				temp = temp.next;
				l1 = l1.next == null ? new ListNode(0) : l1.next;
				l2 = l2.next == null ? new ListNode(0) : l2.next;
			}
		} while (true);
		if (carry > 0) {
			temp.next = new ListNode(1);
		}
		return result;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(6);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		TowSumListNode twoSum = new TowSumListNode();
		ListNode result = twoSum.addTwoNumbers_v2(l1, l2);
		System.out.println(result.val);
		System.out.println(result.next.val);
		System.out.println(result.next.next.val);
	}
}


