// Source : https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
// Author : cornprincess
// Date   : 2020-03-17

/***************************************************************************************************** 
 *
 * You are given an array of strings words and a string chars.
 * 
 * A string is good if it can be formed by characters from chars (each character can only be used 
 * once).
 * 
 * Return the sum of lengths of all good strings in words.
 * 
 * Example 1:
 * 
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation: 
 * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 * 
 * Example 2:
 * 
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * Output: 10
 * Explanation: 
 * The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 * 
 * Note:
 * 
 * 	1 <= words.length <= 1000
 * 	1 <= words[i].length, chars.length <= 100
 * 	All strings contain lowercase English letters only.
 ******************************************************************************************************/

package FindWordsThatCanBeFormedByCharacters;

import java.util.HashMap;
import java.util.Map;

public class FindWordsThatCanBeFormedByCharacters {
    // use two hashMap to record value of char(key) and number of char(value)
    // Time complexity o(n^3);
    // Sapce complexity o(n^2);
    public int solution(String[] words, String chars) {
        char[] chars1 = chars.toCharArray();
        Map<Character, Integer> map = generateMap(chars1);

        int result = 0;
        for (String s : words) {
            Map<Character, Integer> map1 = generateMap(s.toCharArray());
            boolean flag =  true;
            for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
                if (map.getOrDefault(entry.getKey(), 0) == 0 || entry.getValue() > map.get(entry.getKey())) {
                    flag = false;
                    break;
                }
            }
            result += flag ? s.length() : 0;
        }
        return result;
    }

    private Map<Character, Integer> generateMap(char[] chars) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c: chars) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        return map;
    }
}
