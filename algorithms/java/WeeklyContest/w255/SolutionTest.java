package WeeklyContest.w255;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author zhoutianbin
 * @date 2021/4/4 10:36 AM
 */
public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void truncateSentence() {
        String s = "chopper is not a tanuki";
        System.out.println(s.length());
        int k = 5;
        String ans = solution.truncateSentence(s, k);
        System.out.println("ans:" + ans + "haha");
    }

    @Test
    public void test() {
        int[][] logs = {{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}};
        int k = 5;
        int[] ans = solution.findingUsersActiveMinutes(logs, k);
        System.out.println(Arrays.toString(ans));
    }

    @Test
    public void test2() {
        int[] nums1 = {1, 10, 4, 4, 2, 7};
        int[] nums2 = {9, 3, 5, 1, 7, 4};
        int ans = solution.minAbsoluteSumDiff(nums1, nums2);
        System.out.println(ans);
    }

    @Test
    public void test3() {
        int[] nums1 = {1, 7, 5};
        int[] nums2 = {2, 3, 5};
        int ans = solution.minAbsoluteSumDiff(nums1, nums2);
        System.out.println(ans);
    }

    @Test
    public void test4() {
        int[] nums1 = {1, 10, 4, 4, 2, 7};
        int[] nums2 = {1, 10, 4, 4, 2, 7};
        int ans = solution.minAbsoluteSumDiff(nums1, nums2);
        System.out.println(ans);
    }

    @Test
    public void test5() {
        int[] nums1 = {86,27,43,69,74,75,43,62,90,37,39,94,64,55,59,8,7,39,43,81,22,19,50,30,63,15,38,30,61,50,69,34,83,9,87,83,14,6,41,64,38,75,23,32,49,89,15,97,23,49,20,36,85,58,37,10,39,69,11,62,30,16,2,96,98,84,29,68,64,42,29,81,45,65,58,47,89,55,10,97,30,56,8,71,71,74,18,61,25,80,95,11,45,14,58,27,35,22,57,6};
        int[] nums2 = {13,32,9,62,52,36,42,16,8,56,52,69,52,28,18,60,59,66,73,87,97,31,13,22,42,92,70,73,68,62,11,25,68,79,78,100,48,66,6,81,76,47,12,80,20,84,91,100,68,61,47,3,21,77,58,73,33,55,58,61,6,26,28,47,79,61,45,77,18,20,15,46,65,73,29,65,45,100,80,35,54,43,14,33,81,2,72,52,20,9,55,73,90,41,78,32,36,27,13,89};
        System.out.println(nums1[11]);
        System.out.println(nums2[11]);
        int ans = solution.minAbsoluteSumDiff(nums1, nums2);
        System.out.println(ans);
    }
}