package ValidParentheses;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-04-27
 * Time: 21:41
 */
public class ValidParenthesesTest {
    private ValidParentheses validParentheses = new ValidParentheses();
    private String testcase1 = "(([({}[])]{}))";
    private String testcase2 = "((())))";

    @Test
    public void isValid() {
        boolean result1 = validParentheses.isValid(testcase1);
        boolean result2 = validParentheses.isValid(testcase2);
        Assert.assertTrue(result1);
        Assert.assertFalse(result2);
    }
}
