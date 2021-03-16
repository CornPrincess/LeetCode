package CodeInterview.RotateMatrixLcci;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-04-07
 * Time: 20:43
 */
public class RotateMatrixLcciTest {
    private RotateMatrixLcci rotateMatrixLcci = new RotateMatrixLcci();
    private int[][] testcase1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    private int[][] testcase2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};

    @Test
    public void rotate_test() {
        rotateMatrixLcci.rotate(testcase1);
        for (int[] row: testcase1) {
            System.out.println(Arrays.toString(row));
        }
    }

    @Test
    public void rotate2_test() {
        rotateMatrixLcci.rotate(testcase2);
        for (int[] row: testcase2) {
            System.out.println(Arrays.toString(row));
        }
    }
}
