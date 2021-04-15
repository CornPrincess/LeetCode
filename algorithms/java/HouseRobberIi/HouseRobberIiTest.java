package HouseRobberIi;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhoutianbin
 * @date 2021/4/15 11:18 AM
 */
public class HouseRobberIiTest {
    private HouseRobberIi houseRobberIi = new HouseRobberIi();

    @Test
    public void rob() {
        int[] nums = {2, 3,2};
        int ans = houseRobberIi.rob(nums);
        System.out.println(ans);
    }
}