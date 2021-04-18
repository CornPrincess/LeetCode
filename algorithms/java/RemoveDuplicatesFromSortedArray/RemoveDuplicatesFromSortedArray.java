// Source : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// Author : cornprincess
// Date   : 2021-04-18

/***************************************************************************************************** 
 *
 * Given a sorted array nums, remove the duplicates in-place such that each element appears only once 
 * and returns the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array 
 * in-place with O(1) extra memory.
 *
 * Clarification:
 *
 * Confused why the returned value is an integer but your answer is an array?
 *
 * Note that the input array is passed in by reference, which means a modification to the input array 
 * will be known to the caller as well.
 *
 * Internally you can think of this:
 *
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 *
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2]
 * Explanation: Your function should return length = 2, with the first two elements of nums being 1 
 * and 2 respectively. It doesn't matter what you leave beyond the returned length.
 *
 * Example 2:
 *
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4]
 * Explanation: Your function should return length = 5, with the first five elements of nums being 
 * modified to 0, 1, 2, 3, and 4 respectively. It doesn't matter what values are set beyond the 
 * returned length.
 *
 * Constraints:
 *
 * 	0 <= nums.length <= 3 * 104
 * 	-104 <= nums[i] <= 104
 * 	nums is sorted in ascending order.
 ******************************************************************************************************/

package RemoveDuplicatesFromSortedArray;

public class RemoveDuplicatesFromSortedArray {
    // core 双指针，快指针用来扫描数组，慢指针用来记录新数据的索引
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        // core 从第二个数字开始，因为第一个数字一定会被记录
        // 1 1 2
        int fast = 1;
        int slow = 1;
        while (fast < nums.length) {
            while (fast < nums.length && nums[fast] == nums[fast - 1]) {
                fast++;
            }
            if (fast == nums.length) {
                break;
            }
            nums[slow++] = nums[fast++];
        }
        return slow;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int fast = 1;
        int slow = 1;

        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }


    public int removeDuplicates3(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        // 1 2 2 3
        int slow = 0;
        int fast = 1;
        for (; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    // TODO tongyong jiefa

}
