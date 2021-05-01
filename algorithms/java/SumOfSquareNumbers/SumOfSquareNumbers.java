package SumOfSquareNumbers;
// Source : https://leetcode-cn.com/problems/sum-of-square-numbers/
// Author : cornprincess
// Date   : 2021-04-28

import java.util.HashMap;
import java.util.Map;

/*****************************************************************************************************
 *
 * Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
 *
 * Example 1:
 *
 * Input: c = 5
 * Output: true
 * Explanation: 1 * 1 + 2 * 2 = 5
 *
 * Example 2:
 *
 * Input: c = 3
 * Output: false
 *
 * Example 3:
 *
 * Input: c = 4
 * Output: true
 *
 * Example 4:
 *
 * Input: c = 2
 * Output: true
 *
 * Example 5:
 *
 * Input: c = 1
 * Output: true
 *
 * Constraints:
 *
 * 	0 <= c <= 231 - 1
 ******************************************************************************************************/

public class SumOfSquareNumbers {
    // brute force
    public boolean judgeSquareSum(int c) {
        // core 注意这里一定要带等于
        for (long a = 0; a * a <= c; a++) {
//            long b = (int) Math.sqrt(c - a * a);
//            if (a * a + b * b == c) {
//                return true;
//            }
            double b = Math.sqrt(c - a * a);
            //  core 核心代码
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }

    // two points
    public boolean judgeSquareSum2(int c) {
        // 头尾指针的方法，头指针指向0， 尾指针指向sqrt(c)
        int a = 0;
        int b = (int) Math.sqrt(c);
        while (a <= b) {
            int res = a*a + b*b;
            if (res == c) {
                return true;
            } else if (res < c) {
                a++;
            } else {
                b--;
            }
        }
        return false;
    }
}
