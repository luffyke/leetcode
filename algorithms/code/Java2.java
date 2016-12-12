package org.smartx;

/**
 * <b><code>Java2</code></b>
 * <p>
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * </p>
 * @author kext
 */
public class Java2 {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// 算出两个节点的长度，取出最长的作为循环
		int l1Size = 0;
		int l2Size = 0;
		ListNode l1Temp = l1;
		ListNode l2Temp = l2;
		while (l1Temp != null) {
			l1Size++;
			l1Temp = l1Temp.next;
		}
		while (l2Temp != null) {
			l2Size++;
			l2Temp = l2Temp.next;
		}
		int size = l1Size >= l2Size ? l1Size : l2Size;
		// 用于标识两个数相加是否超过10
		int oneOrZero = 0;
		// 结果
		ListNode result = null;
		// 当前节点
		ListNode cur = null;
		// 上一个节点
		ListNode last = null;
		for (int i = 0; i < size; i++) {
			int val1 = 0;
			int val2 = 0;
			if (l1 != null) {
				// 取出当前值和移到下一个节点
				val1 = l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				val2 = l2.val;
				l2 = l2.next;
			}
			int tempVal = val1 + val2 + oneOrZero;
			int val = tempVal >= 10 ? tempVal - 10 : tempVal;
			oneOrZero = tempVal >= 10 ? 1 : 0;
			if (i == 0) {
				result = new ListNode(val);
				cur = result;
				last = result;
			} else {
				cur = new ListNode(val);
				// 上一个节点的下一个节点是当前节点
				last.next = cur;
				// 当前节点变为上一个节点
				last = cur;
			}
			// 最后一个大于10要拼接一个1
			if (i == size - 1 && oneOrZero == 1) {
				cur.next = new ListNode(1);
			}
		}
		return result;
	}
}
