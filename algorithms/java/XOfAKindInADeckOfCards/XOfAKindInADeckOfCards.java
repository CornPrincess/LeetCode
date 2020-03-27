// Source : https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
// Author : cornprincess
// Date   : 2020-03-27

/***************************************************************************************************** 
 *
 * In a deck of cards, each card has an integer written on it.
 *
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck 
 * into 1 or more groups of cards, where:
 *
 * 	Each group has exactly X cards.
 * 	All the cards in each group have the same integer.
 *
 * Example 1:
 *
 * Input: deck = [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
 *
 * Example 2:
 *
 * Input: deck = [1,1,1,2,2,2,3,3]
 * Output: false&acute;
 * Explanation: No possible partition.
 *
 * Example 3:
 *
 * Input: deck = [1]
 * Output: false
 * Explanation: No possible partition.
 *
 * Example 4:
 *
 * Input: deck = [1,1]
 * Output: true
 * Explanation: Possible partition [1,1].
 *
 * Example 5:
 *
 * Input: deck = [1,1,2,2,2,2]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[2,2].
 *
 * Constraints:
 *
 * 	1 <= deck.length <= 10^4
 * 	0 <= deck[i] < 10^4
 ******************************************************************************************************/

package XOfAKindInADeckOfCards;

import java.util.HashMap;
import java.util.Map;

public class XOfAKindInADeckOfCards {
    // Time Complexity：O(N^2)
    // Space Complexity：O(N)
    public boolean bruteForce(int[] deck) {
        int x = 2;
        Map<Integer, Integer> count = new HashMap<>();

        for (int i : deck) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        boolean result = false;
        while (x <= deck.length) {
            if (deck.length % x == 0) {
                result = true;
                for (Integer value : count.values()) {
                    if (value % x != 0) {
                        result = false;
                        break;
                    }
                }

                if (result) {
                    break;
                }
            }
            x++;
        }
        return result;
    }

    public boolean gcd(int[] deck) {
        int len = deck.length;
        if (len < 2) {
            return false;
        }

        // 计数数组，10000 是根据题目给出的数值范围定的
        int[] cnt = new int[10000];
        for (int num : deck) {
            cnt[num]++;
        }

        // 先得到第 1 个数的个数，以避免在循环中赋值
        int x = cnt[deck[0]];

        for (int i = 0; i < 10000; i++) {
            if (cnt[i] == 1) {
                return false;
            }

            if (cnt[i] > 1) {
                x = gcd(x, cnt[i]);

                // 这里做判断可以提前终止运行，也可以等到最后再做，各有优劣，任选其一
                if (x == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
