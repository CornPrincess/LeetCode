package ReverseLinkedList;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-03-10
 * Time: 22:44
 */
public class ReverseLinkedListTest {
    private ReverseLinkedList solution = new ReverseLinkedList();

    @Test
    public void test_reverseLinkedList() {
        int[] array = {1, 2, 3, 4, 5, 6};
        ListNode head = ListNode.arrayToList(array);
        System.out.println(head);
        ListNode reversedHead = solution.reverseList(head);
        String expectedString = ListNode.listToString(reversedHead);
        System.out.println(expectedString);
        Assert.assertEquals("6, 5, 4, 3, 2, 1", expectedString);
    }
}
