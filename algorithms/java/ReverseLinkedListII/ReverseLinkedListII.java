// Source : https://leetcode.com/problems/reverse-linked-list-ii/
// Author : zhoutianbin
// Date   : 2021-03-18

/***************************************************************************************************** 
 *
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse 
 * the nodes of the list from position left to position right, and return the reversed list.
 * 
 * Example 1:
 * 
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * 
 * Example 2:
 * 
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 * 
 * Constraints:
 * 
 * 	The number of nodes in the list is n.
 * 	1 <= n <= 500
 * 	-500 <= Node.val <= 500
 * 	1 <= left <= right <= n
 * 
 * Follow up: Could you do it in one pass?
 ******************************************************************************************************/

package ReverseLinkedListII;

public class ReverseLinkedListII {
    // 主要思路还是和反转链表一样
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null || left == right) {
            return head;
        }

        ListNode dump = new ListNode(-1);
        dump.next = head;

        // 反转区域第一个节点
        ListNode curr = dump;
        // 反转区域前一个节点
        ListNode t1 = null;
        // 反转区域后一个节点
        ListNode t2 = dump;

        // find curr and t1
        // -1 1 2 3 4 5
        for (int i = 0; i < left; i++) {
            t1 = curr;
            curr = curr.next;
        }

        // find t2
        for (int i = 0; i <= right; i++) {
            t2 = t2.next;
        }

        // reverse list
        for (int i = 0; i < right - left +1; i++) {
            ListNode temp = curr.next;
            curr.next = t2;
            t2 = curr;
            curr = temp;
        }
        t1.next = t2;
        return dump.next;
    }

    // 更优解，使用一次遍历，主题思路为逐个将要反转的元素移动位置：
    /*
     * 1 |2 3 4| 5
     *
     * 1    |3    2    4|  5
     * pre  curr next
     * 1 |4 3 2| 5
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        if (head.next == null || left == right) {
            return head;
        }
        // 初始化三个指针
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode pre = dump;
        ListNode curr = null;
        ListNode next = null;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        curr = pre.next;
        next = curr.next;

        // 开始反转
        for (int i = 0; i < right - left; i++) {
            // 一次反转结束
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
            // 更新指针
            next = curr.next;
        }
        return dump.next;
    }
}

