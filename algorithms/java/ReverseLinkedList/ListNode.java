package ReverseLinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-03-10
 * Time: 22:36
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return listToString(this);
    }

    public static ListNode arrayToList(int[] array) {
        if (array == null || array.length < 1) {
            return null;
        }

        ListNode head = new ListNode(-1);
        ListNode temp = head;
        for (int i : array) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        return head.next;
    }

    public static String listToString(ListNode head) {
        if (head == null) {
            return "222";
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (head.next != null) {
            stringBuilder.append(head.val).append(", ");
            head = head.next;
        }
        stringBuilder.append(head.val);
        return stringBuilder.toString();
    }
}
