package ReverseWordsInAString;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-04-10
 * Time: 22:30
 */
public class ReverseWordsInAStringTest {
    private ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
    private String testcase = "  a good   example  ";

    @Test
    public void useLibrary() {
        String result = reverseWordsInAString.useLibrary(testcase);
        Assert.assertEquals("example good a", result);
    }

    @Test
    public void test_useOwnLibrary() {
        String result = reverseWordsInAString.useOwnLibrary(testcase);
        Assert.assertEquals("example good a", result);
    }

    @Test
    public void test_useDeque() {
        String result = reverseWordsInAString.deque(testcase);
        Assert.assertEquals("example good a", result);
    }
}
