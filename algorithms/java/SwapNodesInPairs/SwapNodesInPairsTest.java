package SwapNodesInPairs;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-04-21
 * Time: 21:30
 */
public class SwapNodesInPairsTest {
    private SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
    private int[] testcaseArray = {1, 2, 3, 4};
    private ListNode testcase = ListNode.arrayToList(testcaseArray);

    @Test
    public void test_iterative() {
        System.out.println(testcase);
        ListNode result = swapNodesInPairs.iterative(testcase);
        String actualString = ListNode.listToString(result);
        System.out.println(result);
        Assert.assertEquals("2, 1, 4, 3", actualString);
    }

    @Test
    public void test_recursive() {
        System.out.println(testcase);
        ListNode result = swapNodesInPairs.recursive(testcase);
        String actualString = ListNode.listToString(result);
        System.out.println(result);
        Assert.assertEquals("2, 1, 4, 3", actualString);
    }
}
