package ImplementStackUsingQueues;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-03-10
 * Time: 22:04
 */
public class MyStackTest {
    private MyStack stack = new MyStack();

    @Before
    public void setUp() {
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(3);
    }

    @Test
    public void test_myStack() {
        int pop = stack.pop();
        int top = stack.top();
        boolean empty = stack.empty();
        Assert.assertEquals(3, pop);
        Assert.assertEquals(1, top);
        Assert.assertFalse(empty);
    }
}
