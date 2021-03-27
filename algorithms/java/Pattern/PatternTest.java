package Pattern;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author zhoutianbin
 * @date 2021/3/24 1:00 PM
 */
public class PatternTest {
    Pattern pattern = new Pattern();

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

    @Test
    public void find132patterni() {
        int[] nums = {1,0,1,-4,-3};
    }
}
