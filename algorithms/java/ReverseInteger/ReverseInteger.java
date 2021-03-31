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
    // 时间复杂度: O(logx)
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
            res = res * 10 + digit;
        }
        return (int) res;
    }

    // 取出数位再进行重新拼凑
    // 时间复杂度: O(logx)
    // 空间复杂度: O(1)
    public int reverse2(int x) {
        int res = 0;
        while (x != 0) {
            int digit = x % 10;
            /* core 不能这么判断，因为 res * 10 + digit 的计算结果永远是int，永远不可能大于最大值或者小于最小值
                if ((res * 10 + digit)> Integer.MAX_VALUE || (res * 10 + digit)< Integer.MIN_VALUE ) {
                return 0;
                }
             */
            // core 一定要分开判断
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && digit > 7) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && digit < -8) {
                return 0;
            }
            res = res * 10 + digit;
            x /= 10;
        }
        return res;
    }
}
