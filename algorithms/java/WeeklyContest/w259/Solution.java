package WeeklyContest.w259;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoutianbin
 * @date 2021/5/2 10:29 AM
 */
public class Solution {
    /**
     * 输入：nums = [1,1,1,1,1,1,1,1,1,1], target = 1, start = 0
     * 输出：0
     * 解释：nums 中的每个值都是 1 ，但 nums[0] 使 abs(i - start) 的结果得以最小化，所以答案是 abs(0 - 0) = 0 。
     */
    public int getMinDistance(int[] nums, int target, int start) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                ans = Math.min(ans, Math.abs(i - start));
            }
        }
        return ans;
    }

    public boolean splitString(String s) {
        return false;
    }


    // abc
    // a b c
    List<String> t = new ArrayList<>();
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> subsets(String s) {
        dfs(0, s);
        return ans;
    }

    private void dfs(int curr, String s) {
        if (curr == s.length()) {
            ans.add(new ArrayList<>(t));
            return;
        }

        // 将当前数字切分
        t.add(s.substring(0, curr));
        dfs(curr + 1, s);
        // 不切分当前的数字
        t.remove(t.size() - 1);
        t.add(s.substring(Math.max(curr - 1, 0)));
        dfs(curr + 1, s);
    }

    /**
     * 输入：num = "11112", k = 4
     * 输出：4
     * 解释：第 4 个最小妙数是 "21111" ，要想得到这个数字：
     * - 交换下标 3 和下标 4 对应的位："11112" -> "11121"
     * - 交换下标 2 和下标 3 对应的位："11121" -> "11211"
     * - 交换下标 1 和下标 2 对应的位："11211" -> "12111"
     * - 交换下标 0 和下标 1 对应的位："12111" -> "21111"
     */
    public int getMinSwaps(String num, int k) {
        return -1;
    }

    /**
     * 输入：intervals = [[2,3],[2,5],[1,8],[20,25]], queries = [2,19,5,22]
     * 输出：[2,-1,4,6]
     * 解释：查询处理如下：
     * - Query = 2 ：区间 [2,3] 是包含 2 的最小区间，答案为 3 - 2 + 1 = 2 。
     * - Query = 19：不存在包含 19 的区间，答案为 -1 。
     * - Query = 5 ：区间 [2,5] 是包含 5 的最小区间，答案为 5 - 2 + 1 = 4 。
     * - Query = 22：区间 [20,25] 是包含 22 的最小区间，答案为 25 - 20 + 1 = 6 。
     */
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int target = queries[i];
            int ans0 = Integer.MAX_VALUE;
            for (int[] interval : intervals) {
                int left = interval[0];
                int right = interval[1];
                if (target >= left && target <= right) {
                    int length = right - left + 1;
                    ans0 = Math.min(ans0, length);
                }
            }
            ans0 = ans0 == Integer.MAX_VALUE ? -1 : ans0;
            ans[i] = ans0;
        }
        return ans;
    }

    public boolean find(int left, int right, int target) {
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (mid == target) {
                return true;
            } else if (mid < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
