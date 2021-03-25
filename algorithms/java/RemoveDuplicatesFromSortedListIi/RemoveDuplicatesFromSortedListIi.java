// Source : https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
// Author : zhoutianbin
// Date   : 2021-03-25

/***************************************************************************************************** 
 *
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only 
 * distinct numbers from the original list. Return the linked list sorted as well.
 * 
 * Example 1:
 * 
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * 
 * Example 2:
 * 
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 * 
 * Constraints:
 * 
 * 	The number of nodes in the list is in the range [0, 300].
 * 	-100 <= Node.val <= 100
 * 	The list is guaranteed to be sorted in ascending order.
 ******************************************************************************************************/

package RemoveDuplicatesFromSortedListIi;

import common.ListNode;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromSortedListIi {
    // 首先看到题目我们知道这是一个有序链表，那么问题就会简单很多
    // 对于链表题目，首先考虑的是多个指针的解法
    // 1 2 2 3 3 4 -- 1 4
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dump = new ListNode(-1);
        dump.next = head;

        ListNode pre = dump;
        // 注意这里 pre 要初始化
        pre.next = null;
        ListNode curr = head;
        boolean inDuplicateRegion = false;

        while (curr != null && curr.next != null) {
            if (curr.val != curr.next.val) {
                if (inDuplicateRegion) {
                    curr = curr.next;
                    inDuplicateRegion = false;
                } else {
                    pre.next = curr;
                    pre = curr;
                    curr = curr.next;
                }
            } else {
                inDuplicateRegion = true;
                curr = curr.next;
            }
        }
        if (inDuplicateRegion) {
            pre.next = null;
        } else{
            pre.next = curr;
        }
        return dump.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dump = new ListNode(-1);
        dump.next = head;

        ListNode pre = dump;
        ListNode curr = head;

        while (curr != null) {
            // core 这里一定要放在前面，删除重复节点
            // core 只要此时的 curr 不是重复元素，就不会进这里的代码， pre.next == curr 就会为true
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            // core pre 与 curr 之间没有重复节点
            if (pre.next == curr) {
                // core 因为经过了上面的判断，此时的curr不是重复节点，这里可以直接移动 pre
                pre = curr;
            } else {
                // core 这里是核心，只是将 pre 指向了 curr.next
                pre.next = curr.next;
            }
            curr = curr.next;
        }
        return dump.next;
    }


    public ListNode deleteDuplicates3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        ListNode temp = head;

        // 统计每个数出现的次数
        while (temp != null) {
            countMap.put(temp.val, countMap.getOrDefault(temp.val, 0) + 1);
            temp = temp.next;
        }
        temp = head;
        ListNode dump = new ListNode(-1);
        ListNode pre = dump;

        // 删除链表中重复的数
        while (temp!= null) {
            if (countMap.get(temp.val) == 1) {
                pre.next = temp;
                pre = pre.next;
            }
            temp = temp.next;
        }
        // core 这一步很重要，删除链表末尾相同的数
        pre.next = null;
        return dump.next;
    }

    // 递归
    public ListNode deleteDuplicates4(ListNode head) {
        // basecase
        if (head == null || head.next == null) {
            return head;
        }

        // 如果第一个数和第二个数不同
        if (head.val != head.next.val) {
            head.next = deleteDuplicates4(head.next);
        } else {
            // 如果前两个数相同，那么直接返回删除前n个相同数的结果
            ListNode next = head.next;
            // core 一定要注意 next.next != null 的判断
            while (next.next != null && next.val == next.next.val) {
                next = next.next;
            }
            next = next.next;
            return deleteDuplicates4(next);
        }
        return head;
    }
}
