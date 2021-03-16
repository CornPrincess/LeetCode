package XOfAKindInADeckOfCards;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-03-27
 * Time: 22:51
 */
public class XOfAKindInADeckOfCardsTest {
    private XOfAKindInADeckOfCards x = new XOfAKindInADeckOfCards();
    private int[] testcase = {1,1,2,2,2,2};
    private int[] testcase2 = {1,1,1,2,2,2,3,3};

    @Test
    public void bruteForce() {
        boolean result = x.bruteForce(testcase);
        assertTrue(result);
        boolean result2 = x.bruteForce(testcase2);
        assertFalse(result2);
    }

    @Test
    public void gcd() {
        boolean result = x.generateGCD(testcase);
        assertTrue(result);
        boolean result2 = x.generateGCD(testcase2);
        assertFalse(result2);
    }
}
