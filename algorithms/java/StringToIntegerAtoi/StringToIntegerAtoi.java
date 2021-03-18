// Source : https://leetcode.com/problems/string-to-integer-atoi/
// Author : cornprincess
// Date   : 2020-04-04

/***************************************************************************************************** 
 *
 * Implement atoi which converts a string to an integer.
 * 
 * The function first discards as many whitespace characters as necessary until the first 
 * non-whitespace character is found. Then, starting from this character, takes an optional initial 
 * plus or minus sign followed by as many numerical digits as possible, and interprets them as a 
 * numerical value.
 * 
 * The string can contain additional characters after those that form the integral number, which are 
 * ignored and have no effect on the behavior of this function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no 
 * such sequence exists because either str is empty or it contains only whitespace characters, no 
 * conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned.
 * 
 * Note:
 * 
 * 	Only the space character ' ' is considered as whitespace character.
 * 	Assume we are dealing with an environment which could only store integers within the 32-bit 
 * signed integer range: [&minus;231,  231 &minus; 1]. If the numerical value is out of the range of 
 * representable values, INT_MAX (231 &minus; 1) or INT_MIN (&minus;231) is returned.
 * 
 * Example 1:
 * 
 * Input: "42"
 * Output: 42
 * 
 * Example 2:
 * 
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 *              Then take as many numerical digits as possible, which gets 42.
 * 
 * Example 3:
 * 
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * 
 * Example 4:
 * 
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical 
 *              digit or a +/- sign. Therefore no valid conversion could be performed.
 * 
 * Example 5:
 * 
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 *              Thefore INT_MIN (&minus;231) is returned.
 ******************************************************************************************************/

package StringToIntegerAtoi;

public class  StringToIntegerAtoi {
    // core 需要判断特殊情况
    // 1. 去除空格
    // 2. 如果都是空格按0处理
    // 3. 存在非数字字符
    // 4. 超过int最大值
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int idx = 0;
        while (idx < n && chars[idx] == ' ') {
            idx++;
        }

        if (idx == n) {
            return 0;
        }

        boolean negative = false;
        if (chars[idx] == '-') {
            negative = true;
            idx++;
        } else if (chars[idx] == '+'){
            idx++;
        } else if (!Character.isDigit(chars[idx])) {
            return 0;
        }

        int ans = 0;
        while (idx < n && Character.isDigit(chars[idx])) {
            int digit = chars[idx] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return negative ? -ans : ans;
    }
}
