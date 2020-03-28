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
        Map<Integer, Integer> count = generateValueCount(deck);

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

    // Time Complexity：O(NlgC)
    // Space Complexity：O(N)
    public boolean generateGCD(int[] deck) {
        int len = deck.length;
        if (len < 2) {
            return false;
        }

        Map<Integer, Integer> count = generateValueCount(deck);

        int gcd = -1;
        for (Integer value : count.values()) {
            if (value < 2) {
                return false;
            }

            if (gcd == -1) {
                gcd = value;
            } else {
                gcd = generateGCD(gcd, value);
            }

            if (gcd < 2) {
                return false;
            }
        }

        return gcd >= 2;
    }

    private Map<Integer, Integer> generateValueCount(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int i : deck) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        return count;
    }

    // 求最大公约数公式： gcd(a, b) = gcd(b, a % b)
    // 不用判断a > b，因为当a < b时，第一此递归会将a与b呼唤
    private int generateGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return generateGCD(b, a % b);
    }
}
