// Source : https://leetcode.com/problems/subsets/
// Author : cornprincess
// Date   : 2021-03-31

/***************************************************************************************************** 
 *
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 * Constraints:
 *
 * 	1 <= nums.length <= 10
 * 	-10 <= nums[i] <= 10
 * 	All the numbers of nums are unique.
 ******************************************************************************************************/

package Subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    // recursive

    /**
     * [1, 2, 3]
     * 000 []
     * 001 [3]
     * 010 [2]
     * 011 [2,3]
     * 100 [1]
     * 101 [1,3]
     * 110 [1,2]
     * 111 [1,2,3]
     * <p>
     * 一共有 2^n 个子集
     * 时间复杂度：O(n * 2^n)
     * 空间复杂度：O(n)
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        // core 我们可以枚举出 2^n 个子集
        // core 既然想到了使用二进制mask来进行建模，那么对于这种形式大概率要使用到位运算
        // core 如 a & 1 << b, a |= 1 << b
        // 外层循环为 mask，遍历所有 mask，[0, 2^n -1]
        for (int mask = 0; mask < (1 << nums.length); mask++) {
            t.clear();
            // 内存循环为对当前对 mask 进行遍历，如果 mask 对对应二进制位为1，则添加 nums 中对应的数，否则不添加
            for (int i = 0; i < nums.length; i++) {
                if ((mask & 1 << i) == 1 << i) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(t));
        }
        return ans;
    }

    /**
     * 递归 回溯 backtracking
     * 时间复杂度：O(n * 2^n)
     * 空间复杂度：O(n), 临时数组 t 为O(n)，递归时栈空间占用 O(n)
     */
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> t = new ArrayList<>();

    public List<List<Integer>> subsets2(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    // 以下代码是二叉树形式的
    private void dfs(int curr, int[] nums) {
        if (curr == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }

        // 取当前的数字
        t.add(nums[curr]);
        dfs(curr + 1, nums);
        // 不取当前的数字
        // core 这行代码很核心，一定要删除，不能干扰其他分支的 t，因为用的是同一个 t
        t.remove(t.size() - 1);
        dfs(curr + 1, nums);
    }

    public List<List<Integer>> subsets3(int[] nums) {
        dfs2(0, nums);
        return ans;
    }

    // core has bug
    private void dfs2(int curr, int[] nums) {
        if (curr == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }

        // core 下面的代码有bug，因为当回到上一个栈时，走不取当前数字分支时，t 中已经存在之前栈存放的数字
        // 不取当前的数字
        dfs2(curr + 1, nums);
        // 取当前的数字
        t.add(nums[curr]);
        dfs2(curr + 1, nums);
    }

    public List<List<Integer>> subsets4(int[] nums) {
        backtrack(0, nums);
        return ans;
    }

    private void backtrack(int curr, int[] nums) {
        ans.add(new ArrayList<>(t));
        for (; curr < nums.length; curr++) {
            // 取当前数
            t.add(nums[curr]);
            backtrack(curr + 1, nums);
            // core 恢复状态
            t.remove(t.size() - 1);
        }
    }

}
