// Source : https://leetcode.com/problems/single-number/
// Author : cornprincess
// Date   : 2020-04-02

/***************************************************************************************************** 
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single 
 * one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra 
 * memory?
 * 
 * Example 1:
 * 
 * Input: [2,2,1]
 * Output: 1
 * 
 * Example 2:
 * 
 * Input: [4,1,2,1,2]
 * Output: 4
 * 
 ******************************************************************************************************/

package SingleNumber;

import java.util.*;

public class SingleNumber {
    // Time Complexity O(n^2)
    // Space Complexity O(n)
    public int listOperation(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i : nums) {
            if (!list.contains(i)) {
                list.add(i);
            } else {
                list.remove(Integer.valueOf(i));
            }
        }
        return list.get(0);
    }

    // Time Complexity O(n)
    // Space Complexity O(n)
    public int mapOperation(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0)+ + 1);
        }

        for (int i: nums) {
            if (map.get(i) == 1) {
                return i;
            }
        }
        return 0;
    }

    // Time Complexity O(n)
    // Space Complexity O(n)
    public int math(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sumOfSet = 0;
        int sumOfNums = 0;

        for (int i : nums) {
            if (!set.contains(i)) {
                set.add(i);
                sumOfSet += i;
            }
            sumOfNums += i;
        }

        return 2 * sumOfSet - sumOfNums;
    }

    /*
     * if we take XOR of zero and some bit, it will return that bit
     *  a  ^ 0 = a
     * If we take XOR of two same bits, it will return 0
     *  a ^ a = 0
     * So we can XOR all bits together to find the unique number.
     *  a ^  b ^ a = a ^ a ^ b = 0 ^ b = b
     */
    // Time Complexity O(n)
    // Space Complexity O(1)
    public int bitwise(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        return result;
    }
}
