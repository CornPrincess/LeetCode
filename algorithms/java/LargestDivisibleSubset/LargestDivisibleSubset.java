// Source : https://leetcode.com/problems/largest-divisible-subset/
// Author : cornprincess
// Date   : 2021-04-23

/***************************************************************************************************** 
 *
 * Given a set of distinct positive integers nums, return the largest subset answer such that every 
 * pair (answer[i], answer[j]) of elements in this subset satisfies:
 *
 * 	answer[i] % answer[j] == 0, or
 * 	answer[j] % answer[i] == 0
 *
 * If there are multiple solutions, return any of them.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,2]
 * Explanation: [1,3] is also accepted.
 *
 * Example 2:
 *
 * Input: nums = [1,2,4,8]
 * Output: [1,2,4,8]
 *
 * Constraints:
 *
 * 	1 <= nums.length <= 1000
 * 	1 <= nums[i] <= 2 * 109
 * 	All the integers in nums are unique.
 ******************************************************************************************************/

package LargestDivisibleSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        // 用于回溯
        int[] route = new int[n];
        // 对dp数组的定义很关键，dp[i] 表示将 nums[i] 放入答案集合中，集合的长度
        int[] dp = new int[n];

        // [9,18,54,90,108,180,360,540,720]
        for (int i = 0; i < n; i++) {
            // core 以下两个变量记录最大整除子集
            int len = 1;
            int prev = i;
            for (int j = 0; j < i; j++) {
                // core 判断 nums[i] 能否接到 nums[j] 后面
                if (nums[i] % nums[j] == 0) {
                    // core dp[j]+1 表示将 i 接到 当前 j 之后集合的长度
                    if (dp[j] + 1 > len) {
                        len = dp[j] + 1;
                        prev = j;
                    }
                }
            }
            // core 记录当前 dp[i]
            dp[i] = len;
            route[i] = prev;
        }

        // 2. 遍历dp找到最大的i
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }

        // 3. 回溯 route 得到答案
        List<Integer> ans = new ArrayList<>();
        // core 注意这里回溯时的判断条件
        while (ans.size() != max){
            ans.add(nums[index]);
            index = route[index];
        }
        return ans;
    }


    public List<Integer> largestDivisibleSubset2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // core 注意，这里一定要是以下的值，即如果 nums 只有一个值，那么 maxIndex = 0， maxSize = 1
        Arrays.fill(dp, 1);
        int maxValue = nums[0];
        int maxSize = 1;

        Arrays.sort(nums);

        // 1. core 构建dp数组
        for (int i = 1; i < n; i++) {
            // 尝试将 nums[i] 塞入每一个 dp[j]， 这层循环计算出 dp[i]，dp[i] 表示包括 nums[i] 的最大集合
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], (dp[j]+1));
                }
            }
            // 在这里计算出最终结果，i 不一定是 dp 数组的最后一个
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxValue = nums[i];
            }
        }

        // 2. 回溯出结果
        List<Integer> ans = new ArrayList<>();
        for (int k = n-1; k >=0 && maxSize > 0; k--) {
            if (dp[k] == maxSize && maxValue % nums[k] == 0) {
                ans.add(nums[k]);
                maxSize--;
                maxValue = nums[k];
            }
        }
        return ans;
    }
}
