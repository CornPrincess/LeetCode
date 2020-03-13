package MajorityElement;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-03-13
 * Time: 21:53
 */
public class MajorityElementTest {
    private int[] nums = {1, 2, 3, 3, 3, 2};
    private int[] nums2 = {1, 2, 3, 3, 3, 2, 3};

    private MajorityElement solution = new MajorityElement();

    @Test
    public void test_bruteForce() {
        int result = solution.bruteForce(nums);
        int result2 = solution.bruteForce(nums2);
        Assert.assertEquals(-1, result);
        Assert.assertEquals(3, result2);
    }

    @Test
    public void test_hashMap() {
        int result = solution.hashMap(nums);
        int result2 = solution.hashMap(nums2);
        Assert.assertEquals(-1, result);
        Assert.assertEquals(3, result2);
    }

    @Test
    public void test_sorts() {
        int result = solution.sort(nums2);
        Assert.assertEquals(3, result);
    }

    @Test
    public void test_randomization() {
        int result = solution.randomization(nums2);
        Assert.assertEquals(3, result);
    }

    @Test
    public void test_divide_and_conquer() {
        int result = solution.divideAndConquer(nums2);
        Assert.assertEquals(3, result);
    }

}
