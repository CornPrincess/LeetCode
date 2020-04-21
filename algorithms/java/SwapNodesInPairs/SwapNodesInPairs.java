// Source : https://leetcode.com/problems/swap-nodes-in-pairs/
// Author : cornprincess
// Date   : 2020-04-21

/***************************************************************************************************** 
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * 
 * Example:
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 ******************************************************************************************************/

package SwapNodesInPairs;

public class SwapNodesInPairs {
    public ListNode iterative(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevNode = dummy;

        while (head != null && head.next != null) {
            // nodes to be swapper
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // swap nodes
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next;
        }
        return dummy.next;
    }

    public ListNode recursive(ListNode head) {
        // If the list has no node or has only one left.
        if (head == null || head.next == null) {
            return head;
        }

        // nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // swap
        firstNode.next = recursive(secondNode.next);
        secondNode.next = firstNode;

        // now the head is second node
        return secondNode;
    }
}
