package WeeklyContest.w259;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhoutianbin
 * @date 2021/5/2 11:07 AM
 */
public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void test() {
        System.out.println(solution.subsets("abc"));
    }

    @Test
    public void test_find() {
        System.out.println(solution.find(2, 5, 6));
        System.out.println(solution.find(2, 5, 5));
        System.out.println(solution.find(2, 5, 2));
        System.out.println(solution.find(2, 5, 3));
    }

    @Test
    public void test_query() {
        int[][] intervals = {{1,4},{2,4},{3,6},{4,4}};
        int[] querys = {2,3,4,5};
        int[] ans = solution.minInterval(intervals, querys);
        System.out.println(ans);
    }
}