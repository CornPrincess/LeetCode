// Source : https://leetcode.com/problems/distinct-subsequences/
// Author : zhoutianbin
// Date   : 2021-03-17

/***************************************************************************************************** 
 *
 * Given two strings s and t, return the number of distinct subsequences of s which equals t.
 *
 * A string's subsequence is a new string formed from the original string by deleting some (can be 
 * none) of the characters without disturbing the remaining characters' relative positions. (i.e., 
 * "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * It is guaranteed the answer fits on a 32-bit signed integer.
 *
 * Example 1:
 *
 * Input: s = "rabbbit", t = "rabbit"
 * Output: 3
 * Explanation:
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * rabbbit
 * rabbbit
 * rabbbit
 *
 * Example 2:
 *
 * Input: s = "babgbag", t = "bag"
 * Output: 5
 * Explanation:
 * As shown below, there are 5 ways you can generate "bag" from S.
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 *
 * Constraints:
 *
 * 	0 <= s.length, t.length <= 1000
 * 	s and t consist of English letters.
 ******************************************************************************************************/

package DistinctSubsequences;

public class DistinctSubsequences {

    /*
     * 记忆化递归
     * 这道题使用记忆化递归更容易理解
     * 假设字符串 s 和 t 的长度分别为 m 和 n，
     * 我们可以理解为从字符串 s 中挑选 n 个字符去匹配 t，并且从后向前依次选择元素进行对比
     * 以 babgbag，bag为例
     * 若 s[i] == t[j]，则此时有两种情况，即可以选择用 babgba 来匹配 ba， 或者用 babgba 来匹配 bag
     * 若 s[i] != t[j]，此时只有一种情况，即用 babgba 来匹配 bag
     *
     * basecase：
     * 1 当 n = 0 时，此时结果总为1
     * 2 当 m = 0 && n != 0 时，此时结果为0
     */
    int[][] memo;
    public int numDistinct(String s, String t) {
        memo = new int[s.length() + 1][t.length() + 1];
        // core 都初始化为 -1作为标记
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                memo[i][j] = -1;
            }
        }

        int m = s.length();
        int n = t.length();
        if (m < n) {
            return 0;
        }
        return numDistinctRecursive(s, t, 0, 0);
    }

    private int numDistinctRecursive(String s, String t, int indexS, int indexT) {
        // core 注意这里一定要防放在前面，目的是为例方式 indexS == S.length 且 indexAT == t.length 都情况
        if (indexT == t.length()) {
            return 1;
        }

        if (indexS == s.length()) {
            return 0;
        }

        if (memo[indexS][indexT] != -1) {
            return memo[indexS][indexT];
        }

        if (s.charAt(indexS) == t.charAt(indexT)) {
            memo[indexS][indexT] = numDistinctRecursive(s, t, indexS + 1, indexT + 1) + numDistinctRecursive(s, t, indexS + 1, indexT);
        } else {
            memo[indexS][indexT] = numDistinctRecursive(s, t, indexS + 1, indexT);
        }
        return memo[indexS][indexT];
    }

    /*
     * 动态规划
     * 假设字符串 s 和 t 的长度分别为 m 和 n，
     * 1. m < n，不存在子序列，直接返回0
     * 2. m >= n，存在子序列，需要通过动态规划求解
     * 创建二维数组 dp[][]，其中dp[i][j] 表示在 s[i:] 的子序列中 t[j:] 出现的个数
     * （s[i:] 表示 s 从下标 i 到末尾的子字符串， t[j:] 表示 t 从下标 j 到末尾的子字符串）
     *
     * 边界情况：
     *  1. j = n 时，dp[i][n] = 1
     *  2. j < n && i = m 时， dp[m][j] = 0
     *  3. j < n && i < m 时，
     *      1) s[j] == t[j],dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
     *      2) s[j] != t[j],dp[i][j] = dp[i + 1][j]
     */
    public int numDistinct2(String s, String t) {
        int m = s.length();
        int n = t.length();
        // core 以下为多种情况
        // 1. m < n
        if (m < n) {
            return 0;
        }

        // 2. m >= n，此时需要使用动态规划
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }

        for (int i = m - 1; i >= 0; i--) {
            char sChar = s.charAt(i);
            for (int j = n - 1; j >= 0; j--) {
                char tChar = t.charAt(j);
                if (sChar == tChar) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        return dp[0][0];
    }
}
