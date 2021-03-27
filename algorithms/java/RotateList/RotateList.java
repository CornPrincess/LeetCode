// Source : https://leetcode.com/problems/rotate-list/
// Author : cornprincess
// Date   : 2021-03-27

/***************************************************************************************************** 
 *
 * Given the head of a linked list, rotate the list to the right by k places.
 * 
 * Example 1:
 * 
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * 
 * Example 2:
 * 
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 * 
 * Constraints:
 * 
 * 	The number of nodes in the list is in the range [0, 500].
 * 	-100 <= Node.val <= 100
 * 	0 <= k <= 2 * 109
 ******************************************************************************************************/

package RotateList;

import common.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        // 计算链表的长度
        // 1 2 3 4 5
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        temp = head;
        // 计算开始旋转的节点
        if (k == length || k == 0) {
            return head;
        }
        int remainder = k % length;
        int rotateIndex = length - remainder -1;
        for (int i = 0; i < rotateIndex; i++) {
            temp = temp.next;
        }
        // 旋转分为两步
        // 截断
        ListNode newHead = temp.next;
        temp.next = null;
        // 链接
        temp = newHead;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        return newHead;
    }

    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        // 1. 计算链表长度
        ListNode temp = head;
        // core 注意这里长度初始化为1，并且 while 的判断条件为 temp.next != null,
        // core 这样可以是的 temp 在循环结束之后正好是链表的最后一个节点，方便进行成环操作
        int length = 1;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }

        // 2. 计算断开的节点
        int remainder = k % length;
        if (remainder == 0) {
            return head;
        }
        int rotateIndex = length - remainder;
        // 3. core 闭合成环 这一步一定要在 return head 后面，否则会返回成环的链表
        temp.next = head;
        // 4. 断开
        while (rotateIndex > 0) {
            temp = temp.next;
            rotateIndex--;
        }
        ListNode res = temp.next;
        temp.next = null;
        return res;
    }

    public ListNode rotateRight3(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        // 1.计算断开的节点，即k值
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        k %= length;
        if (k == 0) {
            return head;
        }

        // 1 2 3 4 5
        ListNode slow = head;
        ListNode fast = head;
        while (k >0) {
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode res = slow.next;
        slow.next = null;
        fast.next = head;
        return res;
    }
}
