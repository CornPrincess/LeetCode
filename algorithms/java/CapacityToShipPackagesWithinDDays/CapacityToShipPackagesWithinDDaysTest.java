package CapacityToShipPackagesWithinDDays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhoutianbin
 * @date 2021/4/26 10:26 AM
 */
public class CapacityToShipPackagesWithinDDaysTest {
    private CapacityToShipPackagesWithinDDays capacityToShipPackagesWithinDDays = new CapacityToShipPackagesWithinDDays();

    @Test
    public void shipWithinDays() {
        int[] testcase = {1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        int ans = capacityToShipPackagesWithinDDays.shipWithinDays(testcase, D);
        System.out.println(ans);
    }
}