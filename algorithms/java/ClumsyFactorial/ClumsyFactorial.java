// Source : https://leetcode.com/problems/clumsy-factorial/
// Author : cornprincess
// Date   : 2021-04-01

/***************************************************************************************************** 
 *
 * Normally, the factorial of a positive integer n is the product of all positive integers less than 
 * or equal to n.  For example, factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1.
 *
 * We instead make a clumsy factorial: using the integers in decreasing order, we swap out the 
 * multiply operations for a fixed rotation of operations: multiply (*), divide (/), add (+) and 
 * subtract (-) in this order.
 *
 * For example, clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1.  However, these operations are 
 * still applied using the usual order of operations of arithmetic: we do all multiplication and 
 * division steps before any addition or subtraction steps, and multiplication and division steps are 
 * processed left to right.
 *
 * Additionally, the division that we use is floor division such that 10 * 9 / 8 equals 11.  This 
 * guarantees the result is an integer.
 *
 * Implement the clumsy function as defined above: given an integer N, it returns the clumsy factorial 
 * of N.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 7
 * Explanation: 7 = 4 * 3 / 2 + 1
 *
 * Example 2:
 *
 * Input: 10
 * Output: 12
 * Explanation: 12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
 *
 * Note:
 *
 * 	1 <= N <= 10000
 * 	-2^31 <= answer <= 2^31 - 1  (The answer is guaranteed to fit within a 32-bit integer.)
 *
 ******************************************************************************************************/

package ClumsyFactorial;

import java.util.*;

public class ClumsyFactorial {
    List<Integer> temp = new ArrayList<>();
    List<Integer> temp2 = new ArrayList<>();

    public int clumsy(int N) {
        int bar = N % 4;
        int res = 0;
        for (int i = N; i > bar; i -= 4) {
            calc(i);
        }
        if (N > 3) {
            int last = bar > 0 ? calc(bar) : 0;
            res = temp.get(0);
            for (int i = 1; i < temp.size(); i++) {
                res -= temp.get(i);
            }
            for (int i : temp2) {
                res += i;
            }
            res -= last;
        } else {
            res = calc(bar);
        }
        return res;
    }

    private int calc(int N) {
        int tmp = N;
        int mul = 0;
        int t = N - 1;
        while (t > 0 && mul < 3) {
            if (mul % 4 == 0) {
                tmp = tmp * t;
            } else if (mul % 4 == 1) {
                tmp = tmp / t;
            } else if (mul % 4 == 2) {
                temp.add(tmp);
                temp2.add(t);
            }
            mul++;
            t--;
        }
        return tmp;
    }

    // stack
    // 时间复杂度:O(N)
    // 空间复杂度：O(N)
    public int clumsy2(int N) {
        Deque<Integer> stack = new LinkedList<>();
        int mul = 0;
        stack.push(N--);
        int res = 0;
        while (N > 0) {
            if (mul % 4 == 0) {
                stack.push(stack.pop() * N);
            } else if (mul % 4 == 1) {
                stack.push(stack.pop() / N);
            } else if (mul % 4 == 2) {
                stack.push(N);
            } else if (mul % 4 == 3) {
                stack.push(-N);
            }
            N--;
            mul++;
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    // math
    public int clumsy3(int N) {
        if (N == 1) {
            return 1;
        }
        if (N == 2) {
            return 2;
        }
        if (N == 3) {
            return 6;
        }
        if (N == 4) {
            return 7;
        }

        if (N % 4 == 0) {
            return N + 1;
        }
        if (N % 4 <= 2) {
            return N + 2;
        }
        return N - 1;
    }

    // stack
    // 双栈解法 万金油
    // 一个栈用来维护 num， 另一个栈用来维护 ops，其中需要维护运算符的优先级
    public int clumsy4(int N) {
        Deque<Integer> nums = new LinkedList<>();
        Deque<Character> ops = new LinkedList<>();
        char[] chars = {'*', '/', '+', '-'};
        Map<Character, Integer> priorityMap = new HashMap<Character, Integer>() {{
           put('*', 2);
           put('/', 2);
           put('+', 1);
           put('-', 1);
        }};
        int mul = 0;
        // 构造双栈，并且在构造的时候就已经开始优先级高的计算
        while (N > 0) {
            // core 先加入 num
            nums.push(N);
            char op = chars[mul % 4];
            // core 这是重点，先把栈内高优先级的运算符先计算掉，然后再将当前运算符加入
            while (!ops.isEmpty() && priorityMap.get(ops.peek()) >= priorityMap.get(op)) {
                calc(nums, ops);
            }
            // core 后加入op
            if (N > 1) {
                ops.push(op);
            }
            N--;
            mul++;
        }

        // 继续进行计算
        while (!ops.isEmpty()) {
            calc(nums, ops);
        }
        return nums.peek();
    }

    private void calc(Deque<Integer> nums, Deque<Character> chars) {
        int b = nums.pop();
        int a = nums.pop();
        int op = chars.pop();
        int res = 0;
        if (op == '+') {
            res= a + b;
        } else if (op == '*') {
            res= a * b;
        } else if (op == '/') {
            res= a / b;
        } else if (op == '-') {
            res= a - b;
        }
        nums.push(res);
    }
}
