package RotateList;

import common.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhoutianbin
 * @date 2021/3/27 10:49 PM
 */
public class RotateListTest {
    private RotateList rotateList = new RotateList();

    @Test
    public void test() {
        ListNode listNode = rotateList.rotateRight(init(), 2);
        ListNode listNode2 = rotateList.rotateRight2(init(), 2);
        listNode.print();
        listNode2.print();
    }

    private ListNode init() {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        return new ListNode(1, two);
    }
}