package ClumsyFactorial;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhoutianbin
 * @date 2021/4/1 9:52 AM
 */
public class ClumsyFactorialTest {
    private ClumsyFactorial clumsyFactorial = new ClumsyFactorial();

    @Test
    public void clumsy() {
//        final int clumsy = clumsyFactorial.clumsy(13);
        final int clumsy2 = clumsyFactorial.clumsy(10);
//        System.out.println(clumsy);
        System.out.println(clumsy2);
    }

    @Test
    public void test() {
        System.out.println(13 * 12 / 11 + 10);
        System.out.println(9 * 8 / 7 + 6);
        System.out.println(5 * 4 / 3 + 2);
    }

    @Test
    public void test2() {
        System.out.println(10 * 9 / 8 + 7);
        System.out.println(6 * 5 / 4 + 3);
        System.out.println(2 * 1);
        System.out.println(10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1);
    }

    @Test
    public void test3() {
//        System.out.println(clumsyFactorial.clumsy(1));
//        System.out.println(clumsyFactorial.clumsy(2));
//        System.out.println(clumsyFactorial.clumsy(3));
        System.out.println(clumsyFactorial.clumsy(4));
    }

    @Test
    public void table() {
        int[] diff = {1, 2, 2,-1};
        for (int i = 1; i <= 5000; i++) {
            int res = clumsyFactorial.clumsy4(i);
//            System.out.println("N: " + i + ", res: " + res + ", diff: " + (res - i));
            if ((res - i) != diff[i %4]) {
                System.out.println("Diff not common N: " + i);
            }
        }
    }
}