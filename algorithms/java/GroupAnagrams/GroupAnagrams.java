// Source : https://leetcode.com/problems/group-anagrams/
// Author : cornprincess
// Date   : 2020-04-07

/***************************************************************************************************** 
 *
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * Note:
 *
 * 	All inputs will be in lowercase.
 * 	The order of your output does not matter.
 *
 ******************************************************************************************************/

package GroupAnagrams;

import java.util.*;

public class GroupAnagrams {
    // Time Complexity: O(NKlogK)
    // Space Complexity: O(NK)
    public List<List<String>> sortedKeyHashMap(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = String.valueOf(charArray);

            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

    // Time Complexity: O(NK)
    // Space Complexity: O(NK)
    public List<List<String>> countedKeyHashMap(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                stringBuilder.append('#').append(count[i]);
            }
            String key = stringBuilder.toString();

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);

        }
        return new ArrayList<>(map.values());
    }
}
