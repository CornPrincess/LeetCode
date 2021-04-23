package LargestDivisibleSubset;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhoutianbin
 * @date 202111/4/23 111111:42 AM
 */
public class LargestDivisibleSubsetTest {
    private LargestDivisibleSubset instance = new LargestDivisibleSubset();

    @Test
    public void largestDivisibleSubset() {
        int[] nums = {9,18,54,90,108,180,360,540,720};
        instance.largestDivisibleSubset(nums);
    }

    @Test
    public void largestDivisibleSubset2() {
        int[] nums = {2,3,4,8};
        System.out.println(instance.largestDivisibleSubset2(nums));
    }
}