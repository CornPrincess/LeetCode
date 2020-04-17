// Source : https://leetcode.com/problems/jump-game/
// Author : cornprincess
// Date   : 2020-04-17

/***************************************************************************************************** 
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the 
 * array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * Example 1:
 * 
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Example 2:
 * 
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 * 
 ******************************************************************************************************/

package JumpGame;

public class JumpGame {
    // Greedy algorithms
    // Time complexity: o(n)
    // Space complexity o(1)
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int n = nums.length;
        int canMoveMaxLength = 0;
        for (int i = 0; i < n; i++) {
            if (i <= canMoveMaxLength) {
                canMoveMaxLength = Math.max(canMoveMaxLength, i + nums[i]);
                if (canMoveMaxLength >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
