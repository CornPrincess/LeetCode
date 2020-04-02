package GameOfLife;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-04-02
 * Time: 21:36
 */
public class GameOfLifeTest {
    private GameOfLife gameOfLife = new GameOfLife();

    @Test
    public void copyBoard() {
        int[][] testcase = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        int[][] expect = {{0,0,0},{1,0,1},{0,1,1},{0,1,0}};
        gameOfLife.copyBoard(testcase);
        Assert.assertArrayEquals(testcase, expect);
    }

    @Test
    public void bitwise() {
        int[][] testcase = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        int[][] expect = {{0,0,0},{1,0,1},{0,1,1},{0,1,0}};
        gameOfLife.bitwise(testcase);
        Assert.assertArrayEquals(testcase, expect);
    }
}
