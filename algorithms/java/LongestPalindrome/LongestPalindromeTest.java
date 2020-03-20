package LongestPalindrome;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-03-20
 * Time: 22:51
 */
public class LongestPalindromeTest {
    private LongestPalindrome longestPalindrome = new LongestPalindrome();

    @Test
    public void test_greedy() {
        String s = "abccccdd";
        int result = longestPalindrome.greedy(s);
        Assert.assertEquals(7, result);
    }

    @Test
    public void test_greedyRefacted() {
        String s = "abccccdd";
        int result = longestPalindrome.greedyRefacted(s);
        Assert.assertEquals(7, result);
    }

}
