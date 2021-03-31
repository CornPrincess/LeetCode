// Source : https://leetcode.com/problems/subsets-ii/
// Author : cornprincess
// Date   : 2021-03-31

/***************************************************************************************************** 
 *
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power 
 * set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Example 1:
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 * Constraints:
 *
 * 	1 <= nums.length <= 10
 * 	-10 <= nums[i] <= 10
 ******************************************************************************************************/

package SubsetsIi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsIi {
    // backtracking
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, nums, ans, t);
        return ans;
    }

    private void dfs(int curr, int[] nums, List<List<Integer>> ans, List<Integer> t) {
        ans.add(new ArrayList<>(t));
        for (int i = curr; i < nums.length; i++) {
            if (i != curr && nums[i] == nums[i - 1]) {
                continue;
            }
            t.add(nums[i]);
            dfs(i + 1, nums, ans, t);
            t.remove(t.size() - 1);
        }
    }
}
