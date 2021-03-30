package SearchA2dMatrix;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhoutianbin
 * @date 2021/3/30 11:19 AM
 */
public class SearchA2dMatrixTest {
    private SearchA2dMatrix searchA2dMatrix = new SearchA2dMatrix();

    @Test
    public void searchMatrix4() {
        int[][] source = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 13;
        boolean value = searchA2dMatrix.searchMatrix4(source, target);
        System.out.println(value);
    }
}