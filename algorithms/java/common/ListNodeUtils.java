package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhoutianbin
 * @date 2021/4/2 12:12 PM
 */
public class ListNodeUtils {
    public static void print(ListNode head) {
        System.out.print("[");
        while (head != null) {
            if (head.next == null) {
                System.out.print(head.val);
            } else {
                System.out.print(head.val + ", ");
            }
            head = head.next;
        }
        System.out.println("]");
    }

    public static ListNode createByIterator(int[] nums) {
        List<ListNode> temp = new ArrayList<>();
        for (int num : nums) {
            ListNode node = new ListNode(num);
            temp.add(node);
        }
        for (int i = 0; i < temp.size() - 1; i++) {
            temp.get(i).next = temp.get(i + 1);
        }
        return temp.get(0);
    }

    public static ListNode createByRecursive(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        head.next = createByRecursive(Arrays.copyOfRange(nums, 1, nums.length));
        return head;
    }
}
