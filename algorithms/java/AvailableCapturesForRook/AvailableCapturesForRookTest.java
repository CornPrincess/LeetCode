package AvailableCapturesForRook;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-03-26
 * Time: 22:45
 */
public class AvailableCapturesForRookTest {
    private AvailableCapturesForRook availableCapturesForRook = new AvailableCapturesForRook();
    private char[][] testcase = {
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
            {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'},
            {'.', 'p', 'B', 'R', 'B', 'p', '.', '.'},
            {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'},
            {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'}
    };

    @Test
    public void bruteForce() {
        int result = availableCapturesForRook.bruteForce(testcase);
        Assert.assertEquals(result, 0);
    }

    @Test
    public void bruteForce2() {
        int result = availableCapturesForRook.bruteForce2(testcase);
        Assert.assertEquals(result, 0);
    }
}
