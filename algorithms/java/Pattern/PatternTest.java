package Pattern;

import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.*;

/**
 * @author zhoutianbin
 * @date 2021/3/24 1:00 PM
 */
public class PatternTest {

    @Test
    public void find132pattern() {
    }

    @Test
    public void find132pattern2() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);
        priorityQueue.add(1);
        priorityQueue.add(8);
        priorityQueue.add(7);
        System.out.println(priorityQueue);
    }
}