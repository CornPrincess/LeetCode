// Source : https://leetcode.com/problems/evaluate-reverse-polish-notation/
// Author : zhoutianbin
// Date   : 2021-03-20

/***************************************************************************************************** 
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 * 
 * Note that division between two integers should truncate toward zero.
 * 
 * It is guaranteed that the given RPN expression is always valid. That means the expression would 
 * always evaluate to a result, and there will not be any division by zero operation.
 * 
 * Example 1:
 * 
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * 
 * Example 2:
 * 
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * 
 * Example 3:
 * 
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * 
 * Constraints:
 * 
 * 	1 <= tokens.length <= 104
 * 	tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 
 * 200].
 ******************************************************************************************************/

package EvaluateReversePolishNotation;

import java.util.Deque;
import java.util.LinkedList;

public class EvaluateReversePolishNotation {
    // use default stack
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String s: tokens) {
            if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
                int back = stack.pop();
                int front = stack.pop();
                int temp = operate(front, back, s);
                stack.push(temp);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.peek();
    }

    private int operate(int front, int back, String op) {
        switch(op) {
            case "+":
                return front + back;
            case "-":
                return front - back;
            case "*":
                return front * back;
            case "/":
                return front / back;
            default:
                return -1;
        }
    }

    // use array to mock stack
    public int evalRPN2(String[] tokens) {
        int[] stack = new int[(tokens.length + 1) / 2];
        int index = -1;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    index--;
                    stack[index] += stack[index + 1];
                    break;
                case "-":
                    index--;
                    stack[index] -= stack[index + 1];
                    break;
                case "*":
                    index--;
                    stack[index] *= stack[index + 1];
                    break;
                case "/":
                    index--;
                    stack[index] /= stack[index + 1];
                    break;
                default:
                    index++;
                    stack[index] = Integer.parseInt(s);
                    break;
            }
        }
        return stack[0];
    }

}
