// Source : https://leetcode.com/problems/house-robber-ii/
// Author : cornprincess
// Date   : 2021-04-15

/***************************************************************************************************** 
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain 
 * amount of money stashed. All houses at this place are arranged in a circle. That means the first 
 * house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, 
 * and it will automatically contact the police if two adjacent houses were broken into on the same 
 * night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum 
 * amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: nums = [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are 
 * adjacent houses.
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 *
 * Example 3:
 *
 * Input: nums = [0]
 * Output: 0
 *
 * Constraints:
 *
 * 	1 <= nums.length <= 100
 * 	0 <= nums[i] <= 1000
 ******************************************************************************************************/

package HouseRobberIi;

public class HouseRobberIi {
    // dp
    // core 两种情况：取尾部的和不取尾部的
    // dp[i] = (dp[i-1], dp[i])
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // 1, 2, 3
        int n = nums.length;
        return Math.max(dp(nums, 0, n - 1), dp(nums, 1, n));
    }

    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // 1, 2, 3
        int n = nums.length;
        return Math.max(dpChooseFirst(nums), dpChooseEnd(nums));
    }

    private int dp(int[] nums, int start, int end) {
        // core 递推公式
        // dp[0] = nums[0], dp[1] = max(ums[0], nums[1])
        // 1, 2, 3
        // dp[2] = max(dp[1], dp[0] + nums[2])
        // dp[i] = max(dp[i-1], dp[i-2] + nums[i])
        int a = nums[start];
        int b = Math.max(nums[start], nums[start + 1]);
        int ans = Math.max(a, b);
        for (int i = start + 2; i < end; i++) {
            ans = Math.max(b, a + nums[i]);
            a = b;
            b = ans;
        }
        return ans;
    }

    // 选第一个，最后一个不选
    private int dpChooseFirst(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // core dp[i][j] 表示前i个数的结果，并且第i个数的状态为j，j有两种状态，1为选中，0为不选
        // dp[i][0] = max(dp[i-1][1], dp[i-1][0])
        // dp[i][1] = dp[i-1][0] + nums[i];
        int[][] dp = new int[nums.length - 1][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        dp[1][0] = dp[0][1];
        dp[1][1] = nums[1];
        for (int i = 1; i < nums.length - 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 2][0], dp[nums.length - 2][1]);
    }

    // 选最后一个，第一个不选
    private int dpChooseEnd(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // core dp[i][j] 表示前i个数的结果，并且第i个数的状态为j，j有两种状态，1为选中，0为不选
        // dp[i][0] = max(dp[i-1][1], dp[i-1][0])
        // dp[i][1] = dp[i-1][0] + nums[i];
        int[][] dp = new int[nums.length - 1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = dp[0][1];
        dp[1][1] = nums[1];
        for (int i = 1; i < nums.length - 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 2][0] + nums[nums.length - 1], dp[nums.length - 2][1]);
    }
}
