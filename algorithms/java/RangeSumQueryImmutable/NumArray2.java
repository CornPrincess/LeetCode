// Source : https://leetcode.com/problems/range-sum-query-immutable/
// Author : cornprincess
// Date   : 2021-03-29

/***************************************************************************************************** 
 *
 * Given an integer array nums, find the sum of the elements between indices left and right inclusive, 
 * where (left <= right).
 *
 * Implement the NumArray class:
 *
 * 	NumArray(int[] nums) initializes the object with the integer array nums.
 * 	int sumRange(int left, int right) returns the sum of the elements of the nums array in the 
 * range [left, right] inclusive (i.e., sum(nums[left], nums[left + 1], ... , nums[right])).
 *
 * Example 1:
 *
 * Input
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * Output
 * [null, 1, -1, -3]
 *
 * Explanation
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 *
 * Constraints:
 *
 * 	1 <= nums.length <= 104
 * 	-105 <= nums[i] <= 105
 * 	0 <= left <= right < nums.length
 * 	At most 104 calls will be made to sumRange.
 ******************************************************************************************************/

package RangeSumQueryImmutable;

// 前缀和 preSum, caching
// 时间复杂度: 每次检索：O(1)
// 空间复杂度：O(N)
public class NumArray2 {
    // caching
    // core 其实本质是用空间来换时间，这是缓存的应用
    // core 注意left， right都是下标，那么我们假设 preSum[i] 表示数字下标从 0 到 i-1 的和
    // core 那么很容易我们就能得到 sumRange(i, j) == preSum[j+1] - preSum[i]
    private int[] preSum;

    // nums    [1, 2, 3]
    // preSum: [0, 1, 3, 6]
    public NumArray2(int[] nums) {
        preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}
