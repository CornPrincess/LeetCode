// Source : https://leetcode.com/problems/132-pattern/
// Author : zhoutianbin
// Date   : 2021-03-24

/*****************************************************************************************************
 *
 * Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i],
 * nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
 *
 * Return true if there is a 132 pattern in nums, otherwise, return false.
 *
 * Follow up: The O(n^2) is trivial, could you come up with the O(n logn) or the O(n) solution?
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 * Explanation: There is no 132 pattern in the sequence.
 *
 * Example 2:
 *
 * Input: nums = [3,1,4,2]
 * Output: true
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 *
 * Example 3:
 *
 * Input: nums = [-1,3,2,0]
 * Output: true
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 *
 * Constraints:
 *
 * 	n == nums.length
 * 	1 <= n <= 104
 * 	-109 <= nums[i] <= 109
 ******************************************************************************************************/

package Pattern;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class Pattern {
    // 暴力方法 brute force
    // 时间复杂度：O(n^3)
    // 空间复杂度: O(1)
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] >= nums[j]) {
                    continue;
                }
                int k = nums.length - 1;
                while (k > j) {
                    if (nums[i] < nums[k] && nums[j] > nums[k]) {
                        return true;
                    }
                    k--;
                }
            }
        }
        return false;
    }

    // 暴力方法 brute force
    // 时间复杂度：O(n^2)
    // 空间复杂度: O(1)
    public boolean find132patternj(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        for (int j = 1; j < nums.length - 1; j++) {
            int leftMin = Integer.MAX_VALUE;
            for (int i = 0; i < j; i++) {
                if (nums[i] < leftMin) {
                    leftMin = nums[i];
                }
            }

            for (int k = j + 1; k < nums.length; k++) {
                if (nums[k] < nums[j] && leftMin < nums[k]) {
                    return true;
                }
            }
        }
        return false;
    }

    // 暴力方法 brute force
    // 时间复杂度：O(n^2)
    // 空间复杂度: O(1)
    public boolean find132patternk(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        for (int k = 2; k < nums.length; k++) {
            int i = 0;
            for (; i < k - 1; i++) {
                if (nums[i] < nums[k]) {
                    break;
                }
            }

            for (int j = i + 1; j < k; j++) {
                if (nums[k] < nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // 使用 TreeMap 来实现单调集合
    /* 时间复杂度：
     *  初始化map的时间是 O(nlogn)
     *  将 nums[j+1] 从集合中删除的时间复杂度是 O(logn)
     *  wei
     */
    public boolean find132pattern2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        // i 的坐标，即最小值的坐标
        int leftMin = nums[0];

        // k 的取值范围，即次小值的坐标范围
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int k = 2; k < nums.length; k++) {
            map.put(nums[k], map.getOrDefault(nums[k], 0) + 1);
        }

        // 对 j 取值, 即最大值取值
        for (int j = 1; j < nums.length - 1; j++) {
            if (leftMin < nums[j]) {
                // core 这行代码是关键，找出可能的 k
                Integer candidateK = map.ceilingKey(leftMin + 1);
                if (candidateK != null && candidateK < nums[j]) {
                    return true;
                }
            }
            // core 这里的逻辑使用的是单 if，不能使用 if else
            // 因为如果上面的 if 没有返回 true 还是要走下面的逻辑
            // 并且一定要使用 Math.min，为了防止 [-2,1,2,-2,1,2]
            leftMin = Math.min(leftMin, nums[j]);
            map.put(nums[j + 1], map.get(nums[j + 1]) - 1);
            if (map.get(nums[j + 1]) == 0) {
                map.remove(nums[j + 1]);
            }
        }
        return false;
    }

    // 单调栈，作用相当于 map.ceilingKey
    // 从 j 开始遍历
    public boolean find132pattern3(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int maxCandidateK = Integer.MIN_VALUE;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            //  1 3 2 3 5 6 7
            // core 这行代码是精髓所在，因为是从右向左遍历，并且使用了单调栈的特性，
            // 可以保证 k 一定是当前最大的 k
            if (nums[i] < maxCandidateK) {
                return true;
            }
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                maxCandidateK = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
