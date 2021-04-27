// Source : https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
// Author : cornprincess
// Date   : 2021-04-26

/***************************************************************************************************** 
 *
 * A conveyor belt has packages that must be shipped from one port to another within D days.
 *
 * The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with 
 * packages on the conveyor belt (in the order given by weights). We may not load more weight than the 
 * maximum weight capacity of the ship.
 *
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor 
 * belt being shipped within D days.
 *
 * Example 1:
 *
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * Output: 15
 * Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 *
 * Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and 
 * splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
 *
 * Example 2:
 *
 * Input: weights = [3,2,2,4,1,4], D = 3
 * Output: 6
 * Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
 * 1st day: 3, 2
 * 2nd day: 2, 4
 * 3rd day: 1, 4
 *
 * Example 3:
 *
 * Input: weights = [1,2,3,1,1], D = 4
 * Output: 3
 * Explanation:
 * 1st day: 1
 * 2nd day: 2
 * 3rd day: 3
 * 4th day: 1, 1
 *
 * Constraints:
 *
 * 	1 <= D <= weights.length <= 5 * 104
 * 	1 <= weights[i] <= 500
 ******************************************************************************************************/

package CapacityToShipPackagesWithinDDays;

public class CapacityToShipPackagesWithinDDays {
    // 二分的思想
    public int shipWithinDays(int[] weights, int D) {
        // 1. 确定左右边界
        int left = Integer.MIN_VALUE;
        int right = 0;
        for (int i: weights) {
            left = Math.max(left, i);
            right += i;
        }
        // 2. 进行二分查找
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            // core 2.1 计算当前值是否满足要求
            int needDays = 0;
            int single = 0;
            for (int weight : weights) {
                // 1, 2, 3 -- 2
                if ((single + weight) <= mid) {
                    single += weight;
                } else {
                    single = weight;
                    needDays++;
                }
            }
            // core 这里一定要+1，因为还要运最后一批货
            needDays++;
            // core 这里要注意判断的时候不是 needDays == D 就结束了，我们要寻找的是最小的mid，比如，mid = 16， mid = 15 都可以满足 needDays == D，我们要求的就是最终的 15
            if (needDays > D) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}

