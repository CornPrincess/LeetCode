// Source : https://leetcode.com/problems/remove-duplicates-from-sorted-list/
// Author : cornprincess
// Date   : 2021-03-26

/***************************************************************************************************** 
 *
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only 
 * once. Return the linked list sorted as well.
 * 
 * Example 1:
 * 
 * Input: head = [1,1,2]
 * Output: [1,2]
 * 
 * Example 2:
 * 
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * 
 * Constraints:
 * 
 * 	The number of nodes in the list is in the range [0, 300].
 * 	-100 <= Node.val <= 100
 * 	The list is guaranteed to be sorted in ascending order.
 ******************************************************************************************************/

package RemoveDuplicatesFromSortedList;

import common.ListNode;

public class RemoveDuplicatesFromSortedList {
    // 双指针
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode pre = dump;
        ListNode curr = head;

        while (curr != null) {
            // 1 1 2 3 3 4
            // core 这里将将重复的元素进行过滤
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            pre.next = curr;
            pre = curr;
            curr = curr.next;
        }
        return dump.next;
    }

    // 递归
    public ListNode deleteDuplicates2(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val == head.next.val) {
            return deleteDuplicates2(head.next);
        } else {
            head.next = deleteDuplicates2(head.next);
        }
        return head;
    }
}