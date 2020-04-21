// Source : https://leetcode.com/problems/linked-list-cycle-ii/
// Author : cornprincess
// Date   : 2020-04-21

/***************************************************************************************************** 
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * To represent a cycle in the given linked list, we use an integer pos which represents the position 
 * (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the 
 * linked list.
 * 
 * Note: Do not modify the linked list.
 * 
 * Example 1:
 * 
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * 
 * Example 2:
 * 
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * 
 * Example 3:
 * 
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 * 
 * Follow-up:
 * Can you solve it without using extra space?
 ******************************************************************************************************/

package LinkedListCycleIi;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleIi {
    //Time complexity: O(n)
    //Space complexity: O(n)
    public ListNode hashSet(ListNode head) {
        Set<ListNode> visited = new HashSet<>();

        while (head != null) {
            if (visited.contains(head)) {
                return head;
            }
            visited.add(head);
            head = head.next;
        }
        return null;
    }

    //Time complexity: O(n)
    //Space complexity: O(n)
    public ListNode floyd(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode intersect = getIntersect(head);

        if (intersect == null) {
            return null;
        }

        ListNode start = head;

        while (start != intersect) {
            start = start.next;
            intersect = intersect.next;
        }
        return start;
    }

    private ListNode getIntersect(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return fast;
            }
        }
        return null;
    }
}
