package ImplementQueueUsingStacks;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-05-09
 * Time: 13:12
 */
public class ImplementQueueUsingStacksTest {
    private MyQueue myQueue = new MyQueue();
    private MyQueue2 myQueue2 = new MyQueue2();

    @Test
    public void test_MyQueue() {
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        int peek = myQueue.peek();
        int pop = myQueue.pop();
        myQueue.push(4);
        int peek2 = myQueue.peek();
        int pop2 = myQueue.pop();
        Assert.assertEquals(1, peek);
        Assert.assertEquals(1, pop);
        Assert.assertEquals(2, peek2);
        Assert.assertEquals(2, pop2);

        Assert.assertFalse(myQueue.empty());
    }

    @Test
    public void test_MyQueue2() {
        myQueue2.push(1);
        myQueue2.push(2);
        myQueue2.push(3);
        int peek = myQueue2.peek();
        int pop = myQueue2.pop();
        System.out.println(peek);
        System.out.println(pop);
        System.out.println(myQueue2.peek());
    }
}
