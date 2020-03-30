package CodeInterview.JosephusCircle;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-03-30
 * Time: 22:38
 */
public class JosephusCircleTest {
    private JosephusCircle josephusCircle = new JosephusCircle();

    @Test
    public void mockLinkedList_test() {
        int result = josephusCircle.mockLinkedList(5, 3);
        Assert.assertEquals(result, 3);
        int result2 = josephusCircle.mockLinkedList(5, 1);
        Assert.assertEquals(result2, 4);
        int result3 = josephusCircle.mockLinkedList(10, 17);
        Assert.assertEquals(result3, 2);
    }

    @Test
    public void recursive_test() {
        int result = josephusCircle.recursive(5, 3);
        Assert.assertEquals(result, 3);
        int result2 = josephusCircle.recursive(5, 1);
        Assert.assertEquals(result2, 4);
        int result3 = josephusCircle.recursive(10, 17);
        Assert.assertEquals(result3, 2);
    }

    @Test
    public void iterate_test() {
        int result = josephusCircle.iterate(5, 3);
        Assert.assertEquals(result, 3);
        int result2 = josephusCircle.iterate(5, 1);
        Assert.assertEquals(result2, 4);
        int result3 = josephusCircle.iterate(10, 17);
        Assert.assertEquals(result3, 2);
    }
}
