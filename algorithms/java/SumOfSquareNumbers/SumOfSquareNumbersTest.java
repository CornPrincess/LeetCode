package SumOfSquareNumbers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhoutianbin
 * @date 2021/4/28 10:18 AM
 */
public class SumOfSquareNumbersTest {
    private SumOfSquareNumbers sumOfSquareNumbers = new SumOfSquareNumbers();

    @Test
    public void judgeSquareSum() {
        int a = 5;
        System.out.println(Math.sqrt(a));
        double t = Math.sqrt(a);
        System.out.println(Math.pow(t, 2));
        System.out.println(Math.sqrt(4));
        System.out.println( 3 > t);
        System.out.println( 2 > t);
        System.out.println(Math.floor(t));
        System.out.println(2 == 2.0D);
    }

    @Test
    public void judge() {
        boolean ans = sumOfSquareNumbers.judgeSquareSum(2);
        System.out.println(ans);
        sumOfSquareNumbers.judgeSquareSum(0);
    }
}