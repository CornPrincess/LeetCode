package MaximumNestingDepthOfTwoValidParenthesesStrings;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-04-02
 * Time: 00:17
 */
public class MaximumNestingDepthOfTwoValidParenthesesStringsTest {
    private MaximumNestingDepthOfTwoValidParenthesesStrings m = new MaximumNestingDepthOfTwoValidParenthesesStrings();
    private String testcase = "()(())()";

    @Test
    public void evenAndOdd() {
        int[] result = m.evenAndOdd(testcase);
        System.out.println(Arrays.toString(result));
    }
}
