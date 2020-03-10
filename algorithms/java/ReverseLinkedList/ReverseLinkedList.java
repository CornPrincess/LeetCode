// Source : https://leetcode.com/problems/reverse-linked-list/
// Author : cornprincess
// Date   : 2020-03-10

/***************************************************************************************************** 
 *
 * Reverse a singly linked list.
 * 
 * Example:
 * 
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * 
 * Follow up:
 * 
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 ******************************************************************************************************/

package ReverseLinkedList;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nextTemp;
        }
        return pre;
    }
}
