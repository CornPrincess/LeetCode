// Source : https://leetcode.com/problems/middle-of-the-linked-list/
// Author : cornprincess
// Date   : 2020-03-23

/***************************************************************************************************** 
 *
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * 
 * If there are two middle nodes, return the second middle node.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * 
 * Example 2:
 * 
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 * 
 * Note:
 * 
 * 	The number of nodes in the given list will be between 1 and 100.
 * 
 ******************************************************************************************************/

package MiddleOfTheLinkedList;

public class MiddleOfTheLinkedList {
    public ListNode transferArray(ListNode head) {
        ListNode[] list = new ListNode[100];
        int t = 0;

        while (head != null) {
            list[t++] = head;
            head = head.next;
        }
        return list[t / 2];
    }

    public ListNode iterater(ListNode head) {
        int n = 0;
        ListNode temp = head;

        while (temp != null) {
            n++;
            temp = temp.next;
        }

        for (int i = 0; i < n / 2; i++) {
            head = head.next;
        }

        return head;
    }

    public ListNode towPoints(ListNode head) {
        ListNode low = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
        }

        return low;
    }
}
