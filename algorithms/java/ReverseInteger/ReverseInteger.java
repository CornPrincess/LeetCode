// Source : https://leetcode.com/problems/reverse-integer/
// Author : cornprincess
// Date   : 2021-03-30

/***************************************************************************************************** 
 *
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value 
 * to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * 
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * 
 * Example 1:
 * Input: x = 123
 * Output: 321
 * Example 2:
 * Input: x = -123
 * Output: -321
 * Example 3:
 * Input: x = 120
 * Output: 21
 * Example 4:
 * Input: x = 0
 * Output: 0
 * 
 * Constraints:
 * 
 * 	-231 <= x <= 231 - 1
 ******************************************************************************************************/

package ReverseInteger;

import java.util.ArrayList;
import java.util.List;

public class ReverseInteger {
    // 取出数位再进行重新拼凑
    // 时间复杂度: O(N)
    // 空间复杂度: O(N)
    public int reverse(int x) {
        // 有符号数最多10位
        List<Integer> temp = new ArrayList<>();
        while (x != 0) {
            // 123
            // 3210 0000 00
            // 0000 0001 23
            temp.add(x % 10);
            x /= 10;
        }
        long res = 0;
        for (int digit : temp) {
            if ((res * 10 + digit) > Integer.MAX_VALUE || (res * 10 + digit) < Integer.MIN_VALUE) {
                return 0;
            }
            res = res *  10 + digit;
        }
        return (int) res;
    }
    // ZTODO
}
