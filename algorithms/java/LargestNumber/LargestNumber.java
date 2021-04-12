// Source : https://leetcode.com/problems/largest-number/
// Author : cornprincess
// Date   : 2021-04-12

/***************************************************************************************************** 
 *
 * Given a list of non-negative integers nums, arrange them such that they form the largest number.
 * 
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * 
 * Example 1:
 * 
 * Input: nums = [10,2]
 * Output: "210"
 * 
 * Example 2:
 * 
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 * 
 * Example 3:
 * 
 * Input: nums = [1]
 * Output: "1"
 * 
 * Example 4:
 * 
 * Input: nums = [10]
 * Output: "10"
 * 
 * Constraints:
 * 
 * 	1 <= nums.length <= 100
 * 	0 <= nums[i] <= 109
 ******************************************************************************************************/

package LargestNumber;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        // [3,30,34,5,9]
        // core 如果最高位相同，那么接下来如何比较，还是需要对两个数进行比较才可以得到结果
        // 3， 31 -- 331
        // 3， 34 -- 343
        // 7， 777775 --
        Integer[] temp = new Integer[nums.length];
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp, (x, y) -> {
            int sx  =10;
            int sy  =10;
            // x = 45
            // y = 456
            // 接下来的步骤求出 45456 和 45645
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            // x 在前面
            int dx = x * sy + y;
            // y 在前面
            int dy = y * sx + x;
            return dy - dx;
        });
        if (temp[0] == 0) {
            return "0";
        }
        for (int t :temp) {
            res.append(t);
        }
        return res.toString();
    }
}
