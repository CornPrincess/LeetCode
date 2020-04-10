// Source : https://leetcode.com/problems/reverse-words-in-a-string/
// Author : cornprincess
// Date   : 2020-04-10

/***************************************************************************************************** 
 *
 * Given an input string, reverse the string word by word.
 * 
 * Example 1:
 * 
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * 
 * Example 2:
 * 
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * 
 * Example 3:
 * 
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed 
 * string.
 * 
 * Note:
 * 
 * 	A word is defined as a sequence of non-space characters.
 * 	Input string may contain leading or trailing spaces. However, your reversed string should 
 * not contain leading or trailing spaces.
 * 	You need to reduce multiple spaces between two words to a single space in the reversed 
 * string.
 * 
 * Follow up:
 * 
 * For C programmers, try to solve it in-place in O(1) extra space.
 ******************************************************************************************************/

package ReverseWordsInAString;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInAString {

    // use jdk library
    // Time Complexity O(n)
    // Space Complexity O(n)
    public String useLibrary(String s) {
        List<String> list = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }

    // use own library
    // Time Complexity O(n)
    // Space Complexity O(n)
    public String useOwnLibrary(String s) {
        // trim space
        StringBuilder stringBuilder = trimSpaces(s);

        // reverse string
        reverse(stringBuilder, 0, stringBuilder.length() - 1);

        // reverse words
        reverseEachWord(stringBuilder);

        return stringBuilder.toString();
    }

    private StringBuilder trimSpaces(String s) {
        int left = 0;
        int right = s.length() - 1;

        // trim left space
        while (left <= right && s.charAt(left) == ' ') left++;

        // trim right space
        while (left <= right && s.charAt(right) == ' ') right--;

        // remove the middle extra space
        StringBuilder stringBuilder = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);

            if (c !=  ' ') {
                stringBuilder.append(c);
            } else if (stringBuilder.charAt(stringBuilder.length() - 1) != ' ') {
                stringBuilder.append(c);
            }

            left++;
        }
        return stringBuilder;
    }

    // 1 2 3 4
    // 1 2 3 4 5
    private void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, temp);
        }
    }

    private void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0;
        int end = 0;

        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') end++;

            reverse(sb, start, end - 1);
            start = end + 1;
            end++;
        }
    }

    // TODO Queue
}
