// Source : https://leetcode.com/problems/happy-number/solution/kuai-le-shu-by-leetcode/
// Author : cornprincess
// Date   : 2020-04-21

/***************************************************************************************************** 
 *
 * Write an algorithm to determine if a number n is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with any positive integer, 
 * replace the number by the sum of the squares of its digits, and repeat the process until the number 
 * equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those 
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * Return True if n is a happy number, and False if not.
 * 
 * Example: 
 * 
 * Input: 19
 * Output: true
 * Explanation: 
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 ******************************************************************************************************/

package HappyNumber;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    // Time complexity O(logn)
    // Space complexity O(logn)
    public boolean hashSet(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }

        return n == 1;
    }

    // Time complexity O(logn)
    // Space complexity O(1)
    public boolean circle(int n) {
        int slow = n;
        int fast = getNext(n);

        while (fast != 1 && fast != slow) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private int getNext(int n) {
        int result = 0;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            result += digit * digit;
        }
        return result;
    }
}
