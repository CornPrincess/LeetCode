package ReverseNodesInKGroup;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-04-22
 * Time: 21:08
 */
public class ReverseNodesInKGroupTest {
    private ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
    private int[] testArray1 = {1, 2, 3, 4, 5};
    private int[] testArray2 = {1, 2, 3, 4, 5, 6};
    private ListNode testcase1 = ListNode.arrayToList(testArray1);
    private ListNode testcase2 = ListNode.arrayToList(testArray2);
    private int k = 3;

    @Test
    public void test_iterative() {
        ListNode result1 = reverseNodesInKGroup.iterative(testcase1, k);
        Assert.assertEquals("3, 2, 1, 4, 5", result1.toString());
        ListNode result2 = reverseNodesInKGroup.iterative(testcase2, k);
        Assert.assertEquals("3, 2, 1, 6, 5, 4", result2.toString());
    }

    @Test
    public void test_recursive() {
        ListNode result1 = reverseNodesInKGroup.recursive(testcase1, k);
        Assert.assertEquals("3, 2, 1, 4, 5", result1.toString());
        ListNode result2 = reverseNodesInKGroup.recursive(testcase2, k);
        Assert.assertEquals("3, 2, 1, 6, 5, 4", result2.toString());
    }
}
