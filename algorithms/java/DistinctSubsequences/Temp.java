package DistinctSubsequences;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 3/17/21
 * Time: 10:59 PM
 */
public class Temp {
    // dp
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m < n) {
            return 0;
        }

        // when i = m, return 0, array default value is 0
        int[][] dp = new int[m + 1][n + 1];

        // when j = n, return 1
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }

    // 空间优化
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] dp = new int[n+1];

        for (int i = 1; i <=m; i++) {
            int pre = 1;
            for (int j =1;j <=n; j++) {
                int cur = dp[j];
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[j] += pre;
                }
                pre = cur;
            }
        }
        return dp[n];
    }

    // todo 空间优化
    public int numDistinct(String s, String t) {
        char[] tChars = t.toCharArray();
        int n = s.length();
        int m = t.length();

        int[] dp = new int[m + 1];  //当前行的数据
        int[] temp = new int[m + 1];    //上一行的数据
        dp[0] = 1;
        temp[0] = 1;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            for (int j = 1; j < m + 1; j++) {
                if (ch == tChars[j - 1]) {
                    dp[j] += temp[j-1];
                }
                temp[j-1] = dp[j-1];    //顺带刷新缓存的上一行数据（数据已经被使用过，可以刷新覆盖）
            }
        }
        return dp[m];
    }
}
