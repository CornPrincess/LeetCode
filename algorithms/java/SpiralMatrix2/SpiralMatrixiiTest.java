package SpiralMatrix2;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

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
}