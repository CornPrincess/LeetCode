package SpiralMatrix2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhoutianbin
 * @date 2021/3/16 12:58 PM
 */
public class SpiralMatrixiiTest {
    private SpiralMatrixii spiralMatrixii = new SpiralMatrixii();

    @Test
    public void test() {
        final int[][] ints = spiralMatrixii.generateMatrix(3);
        System.out.println(Arrays.deepToString(ints));
    }

    @Test
    public void test2() {
        final int[][] ints = spiralMatrixii.generateMatrix2(5);
        for (int[] a: ints) {
            System.out.println(Arrays.toString(a));
        }
    }

    @Test
    public void test3() {
        final int[][] ints = spiralMatrixii.generateMatrix3(5);
        for (int[] a: ints) {
            System.out.println(Arrays.toString(a));
        }
    }

    @Test
    public void test4() {
        String s = (String) null;
        System.out.println(s == null);
    }
}