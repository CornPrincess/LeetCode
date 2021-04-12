package LargestNumber;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 4/13/21
 * Time: 12:04 AM
 */
public class LargestNumberTest {
    private LargestNumber largestNumber = new LargestNumber();

    @Test
    public void largestNumber() {
        int[] nums = {45, 456, 453, 454};
        String s = largestNumber.largestNumber(nums);
        System.out.println(s);
    }

    @Test
    public void test() {
        int x = 34;
        int y  = 33;
        String xy = x + String.valueOf(y);
        String yx = y + String.valueOf(x);
        System.out.println(xy);
        System.out.println(yx);
        System.out.println(xy.compareTo(yx));
    }
}
