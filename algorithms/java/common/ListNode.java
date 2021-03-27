package common;

/**
 @author zhoutianbin
 @date 2021/3/25 9:57 AM
 */
public class ListNode {
     public int val;
     public ListNode next;
     public ListNode() {}
     public ListNode(int val) { this.val = val; }
     public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     public void print() {
          ListNode head = this;
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
}
