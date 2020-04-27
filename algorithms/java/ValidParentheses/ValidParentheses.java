// Source : https://leetcode.com/problems/valid-parentheses/
// Author : cornprincess
// Date   : 2020-04-27

/***************************************************************************************************** 
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the 
 * input string is valid.
 * 
 * An input string is valid if:
 * 
 * 	Open brackets must be closed by the same type of brackets.
 * 	Open brackets must be closed in the correct order.
 * 
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * 
 * Input: "()"
 * Output: true
 * 
 * Example 2:
 * 
 * Input: "()[]{}"
 * Output: true
 * 
 * Example 3:
 * 
 * Input: "(]"
 * Output: false
 * 
 * Example 4:
 * 
 * Input: "([)]"
 * Output: false
 * 
 * Example 5:
 * 
 * Input: "{[]}"
 * Output: true
 * 
 ******************************************************************************************************/

package ValidParentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    private Map<Character, Character> mappings;

    public ValidParentheses() {
        this.mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put(']', '[');
        mappings.put('}', '{');
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            // 如果是左括号，则进栈
            if (mappings.containsValue(c)) {
                stack.push(c);
            // 如果是右括号，先判断栈是否为空，为空直接返回false，若不为空，判断是否与栈中顶部弹出的括号匹配，不匹配返回false，匹配继续循环
            } else if (stack.size() == 0 || stack.pop() != mappings.get(c)){
                return false;
            }
        }
        return stack.size() == 0;
    }
}
