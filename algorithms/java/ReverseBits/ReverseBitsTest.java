package ReverseBits;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhoutianbin
 * @date 2021/3/29 10:03 AM
 */
public class ReverseBitsTest {
    private ReverseBits reverseBits = new ReverseBits();

    @Test
    public void reverseBits() {
        System.out.println(Integer.toBinaryString(-3));
        System.out.println(Integer.toBinaryString(-1073741825));
        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(-1));
        // Integer.parseInt 只能使用 31 位字符串
        System.out.println(Integer.parseInt("1111111111111111111111111111101",2));
        System.out.println("-------------------------");

        System.out.println(Integer.toUnsignedString(-3, 2));
        System.out.println(Integer.toUnsignedString(-1073741825, 2));
        System.out.println(Integer.toUnsignedString(2, 2));
        System.out.println(Integer.toUnsignedString(-1, 2));
        System.out.println(Integer.toUnsignedString(1, 2));
    }

    @Test
    public void test() {
        final String s = reverseBits.tripZero("00000000123120023402340");
        System.out.println(s);
    }

    @Test
    public void test2() {
        int i = 0b01101010101010;
        System.out.println(i);
        System.out.println(Integer.parseInt("10100101000001111010011100", 2));
    }

    @Test
    public void test3() {
        final int i = reverseBits.parseInt("1100");
        System.out.println(i);
        System.out.println("111001011110000010100101000000");
        System.out.println(Integer.MAX_VALUE);
    }

    @Test
    public void test4() {
        System.out.println("11111111111111111111111111111101".length());
        System.out.println("11111111111111111111110111111000".length());
        System.out.println("10111111111111111111111111111111".length());
    }

    @Test
    public void test5() {
        reverseBits.reverseBits(-3);
    }
}