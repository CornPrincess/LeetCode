package HappyNumber;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-04-21
 * Time: 22:15
 */
public class HappyNumberTest {
    private HappyNumber happyNumber = new HappyNumber();
    private int testcase1 = 19;
    private int testcase2 = 116;

    @Test
    public void test_hashSet() {
        boolean result1 = happyNumber.hashSet(testcase1);
        boolean result2 = happyNumber.hashSet(testcase2);
        Assert.assertTrue(result1);
        Assert.assertFalse(result2);
    }

    @Test
    public void test_circle() {
        boolean result1 = happyNumber.circle(testcase1);
        boolean result2 = happyNumber.circle(testcase2);
        Assert.assertTrue(result1);
        Assert.assertFalse(result2);
    }
}
