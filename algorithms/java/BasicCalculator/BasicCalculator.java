// Source : https://leetcode.com/problems/basic-calculator/
// Author : cornprincess
// Date   : 2021-04-01

/***************************************************************************************************** 
 *
 * Given a string s representing an expression, implement a basic calculator to evaluate it.
 * 
 * Example 1:
 * 
 * Input: s = "1 + 1"
 * Output: 2
 * 
 * Example 2:
 * 
 * Input: s = " 2-1 + 2 "
 * Output: 3
 * 
 * Example 3:
 * 
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * 
 * Constraints:
 * 
 * 	1 <= s.length <= 3 * 105
 * 	s consists of digits, '+', '-', '(', ')', and ' '.
 * 	s represents a valid expression.
 ******************************************************************************************************/

package BasicCalculator;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculator {
    // 双栈解法，万金油
    public int calculate(String s) {
        Deque<Integer> nums = new LinkedList<>();
        Deque<Character> ops = new LinkedList<>();

        // core 核心逻辑
        // 1. 遇到空格就跳过
        // 2. 遇到 ( 入栈
        // 3. 遇到 )，开始计算，直到遇到最近的一个 (
        // 4. 遇到运算符比较优先级
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                ops.push('(');
            } else if (s.charAt(i) == '+') {
                ops.push('+');
            } else if (Character.isDigit(s.charAt(i))) {
                nums.push(s.charAt(i) - '0');
            } else if (s.charAt(i) == '-') {
                ops.push('-');
            } else if(s.charAt(i) == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    calc(nums, ops);
                }
                ops.pop();
            }
        }
        while (!ops.isEmpty()) {
            calc(nums, ops);
        }
        return nums.peek();
    }

    private void calc(Deque<Integer> nums, Deque<Character> ops) {
        int b = nums.pop();
        int a = nums.pop();
        int op = ops.pop();
        int ans = 0;
        if (op =='+') {
            ans = a + b;
        } else if (op == '-') {
            ans = a - b;
        }
        nums.push(ans);
    }
}
