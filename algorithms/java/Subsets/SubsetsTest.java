package Subsets;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zhoutianbin
 * @date 2021/3/31 10:55 AM
 */
public class SubsetsTest {
    private Subsets subsets = new Subsets();

    @Test
    public void subsets() {
        int[] nums = {1, 2, 3};
        final List<List<Integer>> subsets = this.subsets.subsets(nums);
        System.out.println(subsets);
        System.out.println(3 & 1 << 1);
    }

    @Test
    public void testSubsetsBacktracking() {
        int[] nums = {1, 2, 3};
        final List<List<Integer>> list1 = subsets.subsets2(nums);
        System.out.println(list1);
    }

    @Test
    public void testSubsetsBacktracking2() {
        int[] nums = {1, 2, 3};
        final List<List<Integer>> list2 = subsets.subsets3(nums);
        System.out.println(list2);
    }

    @Test
    public void testSubsetsBacktracking3() {
        int[] nums = {1, 2, 3};
        final List<List<Integer>> list2 = subsets.subsets4(nums);
        System.out.println(list2);
    }
}