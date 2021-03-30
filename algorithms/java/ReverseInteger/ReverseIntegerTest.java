package ReverseInteger;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 3/30/21
 * Time: 10:42 PM
 */
public class ReverseIntegerTest {
    private ReverseInteger reverseInteger = new ReverseInteger();

    @Test
    public void reverse() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(-1 % 10);
        System.out.println(-123 % 10);
        System.out.println(-1 / 10);
        System.out.println(21474836471L > Integer.MAX_VALUE);
        long a = 21474836471L;
        System.out.println(a > Integer.MAX_VALUE);
    }

    @Test
    public void test() {
        int reverse = reverseInteger.reverse(-214748364);
        int reverse2 = reverseInteger.reverse(-101);
        System.out.println(reverse);
        System.out.println(reverse2);
    }
}
