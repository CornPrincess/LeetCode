// Source : https://leetcode.com/problems/move-zeroes/
// Author : cornprincess
// Date   : 2020-04-05

/***************************************************************************************************** 
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the 
 * relative order of the non-zero elements.
 * 
 * Example:
 * 
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Note:
 * 
 * 	You must do this in-place without making a copy of the array.
 * 	Minimize the total number of operations.
 ******************************************************************************************************/

package MoveZeroes;

import java.util.ArrayList;
import java.util.List;

public class MoveZeroes {
    public void extraArray(int[] nums){
        int n = nums.length;

        int numZeores = 0;
        for (int i = 0; i < n; i++) {
            numZeores += nums[i] == 0 ? 1 : 0;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                list.add(nums[i]);
            }
        }

        while (numZeores > 0) {
            list.add(0);
            numZeores--;
        }

        for (int i = 0; i < n; i++) {
            nums[i] = list.get(i);
        }
    }
}
