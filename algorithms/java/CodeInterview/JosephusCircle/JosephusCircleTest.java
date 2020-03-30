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
    public void lastRemaining() {
        int result = josephusCircle.mockLinkedList(5, 3);
        Assert.assertEquals(result, 3);
    }
}
