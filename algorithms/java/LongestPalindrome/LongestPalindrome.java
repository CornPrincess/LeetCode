// Source : https://leetcode.com/problems/longest-palindrome/
// Author : cornprincess
// Date   : 2020-03-19

/***************************************************************************************************** 
 *
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest 
 * palindromes that can be built with those letters.
 * 
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * 
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * 
 * Example: 
 * 
 * Input:
 * "abccccdd"
 * 
 * Output:
 * 7
 * 
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * 
 ******************************************************************************************************/

package LongestPalindrome;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestPalindrome {
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int greedy(String s) {
        // A - Z : 65 - 90
        // a - z : 97 - 122
        int[] count = new int[128];
        for (char c: s.toCharArray()) {
            count[c]++;
        }
        System.out.println(Arrays.toString(count));

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 ==  1) {
                ans++;
            }
        }
        return ans;
    }

    // 位运算 x & 1 可以用来判断是基数还是偶数
    // 数组空间可以改小
    public int greedyRefacted(String s) {
        // A - a : 65 - 122, has 58 chars
        int[] count = new int[58];
        for (char c: s.toCharArray()) {
            count[c - 'A']++;
        }

        int ans = 0;
        for (int v: count) {
            ans += v - (v & 1);
        }
        return ans < s.length() ? ans + 1 : ans;
    }

    // TODO stream
    private int greedyByStream(String s) {
        Map<Integer, Integer> count = s.chars().boxed()
                .collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));
        int ans = count.values().stream().mapToInt(i -> i - (i & 1)).sum();
        return ans < s.length() ? ans + 1 : ans;
    }
}
