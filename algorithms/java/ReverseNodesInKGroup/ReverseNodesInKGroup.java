// Source : https://leetcode.com/problems/reverse-nodes-in-k-group/
// Author : cornprincess
// Date   : 2020-04-22

/***************************************************************************************************** 
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked list. If the number 
 * of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * 
 * Example:
 * 
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * Note:
 * 
 * 	Only constant extra memory is allowed.
 * 	You may not alter the values in the list's nodes, only nodes itself may be changed.
 * 
 ******************************************************************************************************/

package ReverseNodesInKGroup;


public class ReverseNodesInKGroup {
    //Time complexity: O(n * k)
    //Space complexity: O(1)
    public ListNode iterative(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevNode = dummy;
        ListNode end = dummy;

        while (head != null && head.next != null) {
            // if K > listNode.size, break
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }

            if (end == null) {
                break;
            }
            ListNode start = prevNode.next;

            // reinitialize nextStart
            ListNode nextStart = end.next;
            // set end.next null to reverse the k nodes
            end.next = null;

            // 连接头部
            prevNode.next = reverse(start);
            // 连接尾部
            start.next = nextStart;
            prevNode = start;
            end = prevNode;
        }
        return dummy.next;
    }

    public ListNode recursive(ListNode head, int k) {
        if (head == null) return null;
        ListNode start = head;
        ListNode end = head;

        for (int i = 0; i < k; i++) {
            // base case 递归的出口，当剩下节点数小于k时直接返回
            if (end == null) {
                return head;
            }
            end = end.next;
        }
        // 反转k个节点，返回当newHead其实是end前一个节点，反转后start相当于最后一个节点
        ListNode newHead = reverse(start, end);
        // 进行递归，反转k个节点后，只需要将当前最后一个节点，即start连上后面反转好的子链即可
        start.next = recursive(end, k);
        // 返回链表全部反转好后的头节点
        return newHead;
    }

    private ListNode reverse(ListNode start) {
        ListNode pre = null;
        ListNode curr = start;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nextTemp;
        }
        return pre;
    }

    // 反转 [start, end) 区间的链表节点
    private ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode curr = start;

        while (curr != end) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
