package MoveZeroes;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-04-05
 * Time: 22:53
 */
public class MoveZeroesTest {
    private MoveZeroes moveZeroes = new MoveZeroes();
    private int[] testcase = {1, 0, 9, 3, 5, 0, 5, 0};

    @Test
    public void extraArray() {
        moveZeroes.extraArray(testcase);
        System.out.println(Arrays.toString(testcase));
    }
}
