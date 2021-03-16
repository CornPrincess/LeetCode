package SingleNumber;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-04-02
 * Time: 22:03
 */
public class SingleNumberTest {
    private SingleNumber singleNumber = new SingleNumber();
    private int[] testcase = {4,1,2,1,2};

    @Test
    public void listOperation() {
        int result = singleNumber.listOperation(testcase);
        Assert.assertEquals(result, 4);
    }

    @Test
    public void mapOperation() {
        int result = singleNumber.mapOperation(testcase);
        Assert.assertEquals(result, 4);
    }

    @Test
    public void math() {
        int result = singleNumber.math(testcase);
        Assert.assertEquals(result, 4);
    }

    @Test
    public void bitwise() {
        int result = singleNumber.bitwise(testcase);
        Assert.assertEquals(result, 4);
    }

    @Test
    public void test() {
        byte a = 1;
        byte b = (byte) (a + 1);
        a += 1.0;
        System.out.println(a);
    }
}
