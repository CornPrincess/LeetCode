package IsValidSerialization;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhoutianbin
 * @date 2021/3/18 9:52 AM
 */
public class IsValidSerializationTest {
    private IsValidSerialization isValidSerialization = new IsValidSerialization();

    @Test
    public void isValidSerialization() {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(3);
        int temp = stack.pop() - 1;
        stack.push(temp);
        System.out.println(stack);
    }

    @Test
    public void isValidSerialization2() {
        String testcase = "9,#,92,#,#";
        System.out.println(isValidSerialization.isValidSerialization2(testcase));
    }

    @Test
    public void isValidSerialization3() {
        String testcase = "9,3,4,#,#,1,#,#,#,2,#,6,#,#";
        Assert.assertTrue(isValidSerialization.isValidSerialization3(testcase));
    }
}