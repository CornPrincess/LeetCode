// Source : https://leetcode.com/problems/house-robber/
// Author : cornprincess
// Date   : 2021-04-15

/***************************************************************************************************** 
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain 
 * amount of money stashed, the only constraint stopping you from robbing each of them is that 
 * adjacent houses have security systems connected and it will automatically contact the police if two 
 * adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum 
 * amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 *
 * Example 2:
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 *
 * Constraints:
 *
 * 	1 <= nums.length <= 100
 * 	0 <= nums[i] <= 400
 ******************************************************************************************************/

package HouseRobber;

public class HouseRobber {
    // dp
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // core 递推公式
        // dp[0] = nums[0], dp[1] = max(ums[0], nums[1])
        // 1, 2, 3
        // dp[2] = max(dp[1], dp[0] + nums[2])
        // dp[i] = max(dp[i-1], dp[i-2] + nums[i])
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    // space improve
    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // core 递推公式
        // dp[0] = nums[0], dp[1] = max(ums[0], nums[1])
        // 1, 2, 3
        // dp[2] = max(dp[1], dp[0] + nums[2])
        // dp[i] = max(dp[i-1], dp[i-2] + nums[i])
        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);
        int ans = Math.max(a, b);
        for (int i = 2; i < nums.length; i++) {
            ans = Math.max(b, a + nums[i]);
            a = b;
            b = ans;
        }
        return ans;
    }

    // dp 二维数组
    public int rob3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // core dp[i][j] 表示前i个数的结果，并且第i个数的状态为j，j有两种状态，1为选中，0为不选
        // dp[i][0] = max(dp[i-1][1], dp[i-1][0])
        // dp[i][1] = dp[i-1][0] + nums[i];
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        dp[1][0] = dp[0][1];
        dp[1][1] = nums[1];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }
}
