// Source : https://leetcode.com/problems/palindrome-linked-list/
// Author : cornprincess
// Date   : 2021-04-02

/***************************************************************************************************** 
 *
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 * Example 1:
 *
 * Input: head = [1,2,2,1]
 * Output: true
 *
 * Example 2:
 *
 * Input: head = [1,2]
 * Output: false
 *
 * Constraints:
 *
 * 	The number of nodes in the list is in the range [1, 105].
 * 	0 <= Node.val <= 9
 *
 * Follow up: Could you do it in O(n) time and O(1) space?
 ******************************************************************************************************/

package PalindromeLinkedList;

import common.ListNode;
import common.ListNodeUtils;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        // 1 2 3 3 2 1
        List<Integer> origin = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            origin.add(temp.val);
            temp = temp.next;
        }

        ListNode reverse = reverse(head);
        for (int i : origin) {
            if (reverse.val != i) {
                return false;
            }
            reverse = reverse.next;
        }
        return true;
    }

    // two points
    public boolean isPalindrome2(ListNode head) {
        if (head.next == null) {
            return true;
        }
        // 1 2 3 3 2 1
        // 1 2 1
        List<Integer> origin = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            origin.add(temp.val);
            temp = temp.next;
        }

        for (int i = 0, j = origin.size() - 1; i < j; i++, j--) {
            if (!origin.get(i).equals(origin.get(j))) {
                return false;
            }
        }
        return true;
    }

    // recursive
    ListNode front;

    public boolean isPalindrome3(ListNode head) {
        front = head;
        return recursiveCheck(head);
    }

    // 原地算法
    public boolean isPalindrome4(ListNode head) {
        // 先通过快慢指针找到链表中间的节点
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }

        // 翻转后半部分节点
        ListNode reverseHalf = reverse(slow);

        // 比较前半部分和后半部分
        while (reverseHalf != null) {
            if (reverseHalf.val != head.val) {
                return false;
            }
            reverseHalf = reverseHalf.next;
            head  = head.next;
        }
        // 恢复后半部分
//        reverse()
        // 返回
        return true;
    }

    public boolean recursiveCheck(ListNode node) {
        if (node != null) {
            if (!recursiveCheck(node.next)) {
                return false;
            }

            if (node.val != front.val) {
                return false;
            }
            front = front.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        ListNodeUtils.print(pre);
        ListNodeUtils.print(pre);
        return pre;
    }
}
