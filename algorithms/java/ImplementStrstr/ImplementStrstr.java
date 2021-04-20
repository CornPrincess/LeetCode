// Source : https://leetcode.com/problems/implement-strstr/
// Author : cornprincess
// Date   : 2021-04-20

/***************************************************************************************************** 
 *
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of 
 * haystack.
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an 
 * interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is 
 * consistent to C's strstr() and Java's indexOf().
 *
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Example 3:
 * Input: haystack = "", needle = ""
 * Output: 0
 *
 * Constraints:
 *
 * 	0 <= haystack.length, needle.length <= 5 * 104
 * 	haystack and needle consist of only lower-case English characters.
 ******************************************************************************************************/

package ImplementStrstr;

public class ImplementStrstr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        // core 特殊情况：haystack.length < needle.length
        if (haystack.length() < needle.length()) {
            return -1;
        }

        // "mississippi"
        // "issipi"
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) != needle.charAt(0)) {
                continue;
            }
            boolean find = true;
            int tempI = i;
            int j = 0;
            for (;j < needle.length() && tempI < haystack.length(); j++) {
                if (haystack.charAt(tempI) != needle.charAt(j)) {
                    find = false;
                    break;
                }
                tempI++;
            }
            if (j != needle.length()) {
                find = false;
            }
            if (find) {
                return i;
            }
        }
        return -1;
    }

    static int indexOf(char[] source, int sourceOffset, int sourceCount,
                       char[] target, int targetOffset, int targetCount,
                       int fromIndex) {
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }

        char first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);

        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first) ;
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++)
                    ;

                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }
}
