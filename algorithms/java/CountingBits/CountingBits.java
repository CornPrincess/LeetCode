// Source : https://leetcode.com/problems/counting-bits/
// Author : cornprincess
// Date   : 2021-03-30

/***************************************************************************************************** 
 *
 * Given an integer num, return an array of the number of 1's in the binary representation of every 
 * number in the range [0, num].
 *
 * Example 1:
 *
 * Input: num = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 *
 * Example 2:
 *
 * Input: num = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 * Constraints:
 *
 * 	0 <= num <= 105
 *
 * Follow up:
 *
 * 	It is very easy to come up with a solution with run time O(32n). Can you do it in linear 
 * time O(n) and possibly in a single pass?
 * 	Could you solve it in O(n) space complexity?
 * 	Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
 ******************************************************************************************************/

package CountingBits;

public class CountingBits {
    // 时间复杂度：O(num * k) 其中 k 为 int 类型的二进制位数，对于java是32
    // 空间复杂度：O(1)
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = countBit(i);
        }
        return res;
    }

    // dp
    // 时间复杂度：O(num * k) 其中 k 为 int 类型的二进制位数，对于java是32
    // 空间复杂度：O(1)
    // core 递归公式
    // 本题 dp 的关键为找到地推公式，就如斐波那切数列一样，这里有两种思路：
    // 从低位开始遍历：f(n) = f(n << 1) + n & (1 << 31)
    // 从高位开始遍历: f(n) = f(n >> 1) + n & 1
    public int[] countBits2(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            // core 注意 i & 1  一定要加括号，因为 & 的优先级是低于 + 的
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

    public int[] countBits3(int num) {
        int[] res = new int[num + 1];
        for (int i = num; i >= 0; i--) {
            // core 注意 i & 1  一定要加括号，因为 & 的优先级是低于 + 的
            // 12 1100
            // 6  0110
            // 3  0011
            int temp = i << 1 <= num ? res[i << 1] : countBit(i << 1);
            res[i] = temp + (i & 1 << 31);
        }
        return res;
    }

    private int countBit(int num) {
        int res = 0;
        while (num != 0) {
            res += num & 1;
            num >>>= 1;
        }
        return res;
    }
}
