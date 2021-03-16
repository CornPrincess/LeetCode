package JumpGame;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-04-17
 * Time: 18:37
 */
public class JumpGameTest {
    private JumpGame jumpGame = new JumpGame();
    private int[] testcase1 = {2,3,1,1,4};
    private int[] testcase2 = {3,2,1,0,4};

    @Test
    public void canJump() {
        boolean result = jumpGame.canJump(testcase1);
        Assert.assertTrue(result);
        boolean result2 = jumpGame.canJump(testcase2);
        Assert.assertFalse(result2);
    }
}
