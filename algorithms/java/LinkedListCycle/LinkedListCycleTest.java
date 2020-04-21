package LinkedListCycle;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-04-21
 * Time: 22:44
 */
public class LinkedListCycleTest {
    private LinkedListCycle linkedListCycle = new LinkedListCycle();
    private ListNode hasCircle = new ListNode(1);
    private ListNode hasNoCircle = new ListNode(1);

    @Before
    public void setUp() {
        ListNode pos = null;
        for (int i = 2; i < 6; i++) {
            hasCircle.next = new ListNode(i);
            hasCircle = hasCircle.next;

            if (i == 4) {
                pos = hasCircle;
            }
        }
        hasCircle.next = pos;
        hasNoCircle.next = null;
    }

    @Test
    public void test_hashSet() {
        boolean result1 = linkedListCycle.hashSet(hasCircle);
        boolean result2 = linkedListCycle.hashSet(hasNoCircle);
        Assert.assertTrue(result1);
        Assert.assertFalse(result2);
    }

    @Test
    public void test_circle() {
        boolean result1 = linkedListCycle.twoPoint(hasCircle);
        boolean result2 = linkedListCycle.twoPoint(hasNoCircle);
        Assert.assertTrue(result1);
        Assert.assertFalse(result2);
    }
}
