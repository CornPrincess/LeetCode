package StringToIntegerAtoi;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-04-04
 * Time: 22:45
 */
public class StringToIntegerAtoiTest {
    private StringToIntegerAtoi atoi = new StringToIntegerAtoi();
    private String testcase = " -42";
    private String testcase2 = " qw-42qw";
    private String testcase3 = "+42qw";

    @Test
    public void myAtoi() {
        int result = atoi.myAtoi(testcase);
        Assert.assertEquals(-42, result);
        int result2 = atoi.myAtoi(testcase2);
        Assert.assertEquals(0, result2);
        int result3 = atoi.myAtoi(testcase3);
        Assert.assertEquals(42, result3);
    }
}
