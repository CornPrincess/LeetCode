// Source : https://leetcode.com/problems/distribute-candies-to-people/
// Author : cornprinicess
// Date   : 2020-03-05

/*****************************************************************************************************
 *
 * We distribute some number of candies, to a row of n = num_people people in the following way:
 *
 * We then give 1 candy to the first person, 2 candies to the second person, and so on until we give n
 * candies to the last person.
 *
 * Then, we go back to the start of the row, giving n + 1 candies to the first person, n + 2 candies
 * to the second person, and so on until we give 2 * n candies to the last person.
 *
 * This process repeats (with us giving one more candy each time, and moving to the start of the row
 * after we reach the end) until we run out of candies.  The last person will receive all of our
 * remaining candies (not necessarily one more than the previous gift).
 *
 * Return an array (of length num_people and sum candies) that represents the final distribution of
 * candies.
 *
 * Example 1:
 *
 * Input: candies = 7, num_people = 4
 * Output: [1,2,3,1]
 * Explanation:
 * On the first turn, ans[0] += 1, and the array is [1,0,0,0].
 * On the second turn, ans[1] += 2, and the array is [1,2,0,0].
 * On the third turn, ans[2] += 3, and the array is [1,2,3,0].
 * On the fourth turn, ans[3] += 1 (because there is only one candy left), and the final array is
 * [1,2,3,1].
 *
 * Example 2:
 *
 * Input: candies = 10, num_people = 3
 * Output: [5,2,3]
 * Explanation:
 * On the first turn, ans[0] += 1, and the array is [1,0,0].
 * On the second turn, ans[1] += 2, and the array is [1,2,0].
 * On the third turn, ans[2] += 3, and the array is [1,2,3].
 * On the fourth turn, ans[0] += 4, and the final array is [5,2,3].
 *
 * Constraints:
 *
 * 	1 <= candies <= 10^9
 * 	1 <= num_people <= 1000
 ******************************************************************************************************/

package DistributeCandiesToPeople;

public class DistributeCandiesToPeople {
    // brute force
    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int n = 0;
        while (candies >  0) {
            for (int i = 0; i < num_people; i++) {
                if (candies > 0) {
                    int dueDistributedCandies = i + 1 + n * num_people;
                    int actualDistributedCandies = candies > dueDistributedCandies ? dueDistributedCandies : candies;
                    result[i] += actualDistributedCandies;
                    candies -= actualDistributedCandies;
                }
            }
            n++;
        }
        return result;
    }

    // sum of arithmetic progression, the code comes from following link
    // https://leetcode-cn.com/problems/distribute-candies-to-people/solution/fen-tang-guo-ii-by-leetcode-solution/
    public int[] distributeCandies2(int candies, int num_people) {
        int n = num_people;
        // how many people received complete gifts
        int p = (int)(Math.sqrt(2 * candies + 0.25) - 0.5);
        int remaining = (int)(candies - (p + 1) * p * 0.5);
        int rows = p / n, cols = p % n;

        int[] d = new int[n];
        for(int i = 0; i < n; ++i) {
            // complete rows
            d[i] = (i + 1) * rows + (int)(rows * (rows - 1) * 0.5) * n;
            // cols in the last row
            if (i < cols) d[i] += i + 1 + rows * n;
        }
        // remaining candies
        d[cols] += remaining;
        return d;
    }

}
