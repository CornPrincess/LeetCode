// Source : https://leetcode.com/problems/minimum-increment-to-make-array-unique/
// Author : cornprincess
// Date   : 2020-03-22

/***************************************************************************************************** 
 *
 * Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.
 * 
 * Return the least number of moves to make every value in A unique.
 * 
 * Example 1:
 * 
 * Input: [1,2,2]
 * Output: 1
 * Explanation:  After 1 move, the array could be [1, 2, 3].
 * 
 * Example 2:
 * 
 * Input: [3,2,1,2,1,7]
 * Output: 6
 * Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
 * It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
 * 
 * Note:
 * 
 * 	0 <= A.length <= 40000
 * 	0 <= A[i] < 40000
 * 
 ******************************************************************************************************/

package MinimumIncrementToMakeArrayUnique;

import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {
    public int counting(int[] A) {
        // Time Complexity: O(N), where N is the length of A.
        //Space Complexity: O(N).
        // 统计每个数字出现的次数
        // 极端情况： 40000个40000，需要自增到80000
        int[] count = new int[80000];
        for (int x: A) {
            count[x]++;
        }

        int ans = 0;
        int taken = 0;
        for (int i = 0; i < 80000; i++) {
            if (count[i] >= 2) {
                // taken：x出现的次数-1，即重复的需要进行增量的数有几个
                taken += count[i] - 1;
                ans -= i * (count[i] - 1);
            } else if (taken > 0 && count[i] == 0) {
                taken--;
                ans += i;
            }
        }
        return ans;
    }

    //时间复杂度：O(Nlog N)，其中 NN 是数组 AA 的长度，即排序的时间复杂度。
    //空间复杂度：O(log N)，排序需要额外 O(\log N)O(logN) 的栈空间。
    public int sort(int[] A) {
        Arrays.sort(A);
        int ans = 0;
        int taken = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i-1] == A[i]) {
                ans -= A[i];
                taken++;
            } else {
                int give = Math.min(taken, A[i] - A[i-1] - 1);
                ans += give * (give + 1) / 2 + give * A[i-1];
                taken -= give;
            }
        }

        if (A.length > 0) {
            ans += taken * (taken + 1) / 2 + taken * A[A.length - 1];
        }
        return ans;
    }

    // TODO 计数排序，线性探测法（hash冲突）

}
