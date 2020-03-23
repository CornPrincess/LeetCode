package MiddleOfTheLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-03-23
 * Time: 22:47
 */
public class MiddleOfTheLinkedListTest {
    private MiddleOfTheLinkedList middleOfTheLinkedList = new MiddleOfTheLinkedList();
    private ListNode testcase = new ListNode(1);

    @Before
    public void setUp() {
        testcase.next = new ListNode(2);
        testcase.next.next = new ListNode(3);
        testcase.next.next.next = new ListNode(4);
        testcase.next.next.next.next = new ListNode(5);
    }

    @Test
    public void transferArray() {
        int result = middleOfTheLinkedList.transferArray(testcase).val;
        Assert.assertEquals(3, result);
    }

    @Test
    public void iterater() {
        int result = middleOfTheLinkedList.iterater(testcase).val;
        Assert.assertEquals(3, result);
    }

    @Test
    public void towPoints() {
        int result = middleOfTheLinkedList.towPoints(testcase).val;
        Assert.assertEquals(3, result);
    }
}
