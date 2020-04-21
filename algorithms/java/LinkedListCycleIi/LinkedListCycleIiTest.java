package LinkedListCycleIi;

import LinkedListCycle.LinkedListCycle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-04-22
 * Time: 00:34
 */
public class LinkedListCycleIiTest {
    private LinkedListCycleIi linkedListCycleIi = new LinkedListCycleIi();
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
        ListNode result1 = linkedListCycleIi.hashSet(hasCircle);
        Assert.assertEquals(5, result1.val);
        ListNode result2 = linkedListCycleIi.hashSet(hasNoCircle);
        Assert.assertNull(result2);
    }

    @Test
    public void test_floyd() {
        ListNode result1 = linkedListCycleIi.floyd(hasCircle);
        Assert.assertEquals(5, result1.val);
        ListNode result2 = linkedListCycleIi.floyd(hasNoCircle);
        Assert.assertNull(result2);
    }
}
