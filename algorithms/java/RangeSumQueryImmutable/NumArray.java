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

// 时间复杂度: 每次检索：O(n)
// 空间复杂度：O(1)
public class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            res += nums[i];
        }
        return res;
    }
}
