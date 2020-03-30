package CodeInterview.JosephusCircle;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-03-30
 * Time: 21:13
 *
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 */
public class JosephusCircle {

    public int mockLinkedList(int n, int m) {
        if (n == 1) {
            return 0;
        }

        ListNode head = generateLinkedList(n);
        printLinkedList(head, n);
        ListNode pre = null;
        ListNode curr = head;

        while (curr.next !=  curr) {
            for (int i = 0; i < m - 1; i++) {
                pre = curr;
                curr = curr.next;
            }
            System.out.println("delete node: " + curr.val);
            pre.next = curr.next;
            curr.next = null;
            curr = pre.next;
        }

        return curr.val;

    }

    private ListNode generateLinkedList(int n) {
        ListNode head = new ListNode(0);
        ListNode pre = head;
        for (int i = 1; i < n; i++) {
            pre.next = new ListNode(i);
            pre = pre.next;
        }
        pre.next = head;
        return head;
    }

    private void printLinkedList(ListNode node, int n) {
        int i = 0;
        while (node != null && i < n) {
            System.out.println(node.val);
            i++;
            node = node.next;
        }
    }

}
