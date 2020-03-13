// Source : https://leetcode.com/problems/majority-element/
// Author : cornprincess
// Date   : 2020-03-13

/***************************************************************************************************** 
 *
 * Given an array of size n, find the majority element. The majority element is the element that 
 * appears more than &lfloor; n/2 &rfloor; times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 *
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 ******************************************************************************************************/

package MajorityElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MajorityElement {
    // Time complexity : O(n^2)
    // Space complexity: O(1)
    public int bruteForce(int[] nums) {
        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count++;
                }
            }
            if (count > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }


    // Time complexity : O(n)
    // Space complexity: O(n)
    public int hashMap(int[] nums) {
        Map<Integer, Integer> map = arrayToMap(nums);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    // Time complexity : O(nlgn)
    // Space complexity: O(1)
    public int sort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // Time complexity : O(∞)
    // Space complexity: O(1)
    public int randomization(int[] nums) {
        Random rand = new Random();
        int majorityCount = nums.length / 2;

        while (true) {
            int candidate = randomRange(rand, 0, nums.length);
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }

    // TODO need learn it
    // Time complexity : O(nlgn)
    // Space complexity: O(lgn)
    public int divideAndConquer(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }

    // Time complexity : O(n)
    // Space complexity: O(1)
    public int boyerMoorevoting(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num: nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case, the only element in an array of size 1 is the majority element
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);

        // if two halves agree on the majority element, return it
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the winner
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    private Map<Integer, Integer> arrayToMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        return map;
    }

    private int randomRange(Random random, int min, int max) {
        return random.nextInt(max - min) + min;
    }

    private int countOccurences(int[] nums, int random) {
        int count = 0;
        for (int num : nums) {
            if (num == random) {
                count++;
            }
        }
        return count;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}
