package MinimumIncrementToMakeArrayUnique;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-03-22
 * Time: 23:04
 */
public class MinimumIncrementToMakeArrayUniqueTest {
    private MinimumIncrementToMakeArrayUnique minimumIncrementToMakeArrayUnique = new MinimumIncrementToMakeArrayUnique();
    private int[] testcase = {3,2,1,2,1,7};

    @Test
    public void minIncrementForUnique() {
        int result = minimumIncrementToMakeArrayUnique.minIncrementForUnique(testcase);
        Assert.assertEquals(6, result);
    }
}
