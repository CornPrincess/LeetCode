package NumberOf1Bits;

import org.junit.Test;

/**
 * @author zhoutianbin
 * @date 2021/3/22 10:59 AM
 */
public class NumberOf1BitsTest {
    private NumberOf1Bits numberOf1Bits = new NumberOf1Bits();

    @Test
    public void hammingWeight() {
        int res = numberOf1Bits.hammingWeight(3);
        System.out.println(res);
    }
}