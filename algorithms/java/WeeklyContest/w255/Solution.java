package WeeklyContest.w255;

import java.util.*;

/**
 * @author zhoutianbin
 * @date 2021/4/4 10:32 AM
 */
public class Solution {
    /**
     * 句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）。
     * <p>
     * 例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。
     * 给你一个句子 s​​​​​​ 和一个整数 k​​​​​​ ，请你将 s​​ 截断 ​，​​​使截断后的句子仅含 前 k​​​​​​ 个单词。返回 截断 s​​​​​​ 后得到的句子。
     * <p>
     * 输入：s = "Hello how are you Contestant", k = 4
     * 输出："Hello how are you"
     * 解释：
     * s 中的单词为 ["Hello", "how" "are", "you", "Contestant"]
     * 前 4 个单词为 ["Hello", "how", "are", "you"]
     * 因此，应当返回 "Hello how are you"
     * <p>
     * 1 <= s.length <= 500
     * k 的取值范围是 [1,  s 中单词的数目]
     * s 仅由大小写英文字母和空格组成
     * s 中的单词之间由单个空格隔开
     * 不存在前导或尾随空格
     *
     * @param s
     * @param k
     * @return
     */
    public String truncateSentence(String s, int k) {
        // Hello how are you Contestant
        int num = 0;
        int i = 0;
        for (; i < s.length(); i++) {
            while (i < s.length() && (('a' <= s.charAt(i) && 'z' >= s.charAt(i)) || ('A' <= s.charAt(i) && 'Z' >= s.charAt(i)))) {
                i++;
            }
            num++;
            if (num == k) {
                break;
            }
        }
        return s.substring(0, i);
    }

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        // 统计用户活跃分钟数
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            int user = log[0];
            int time = log[1];
            Set<Integer> origin = new HashSet<>();
            Set<Integer> set = map.getOrDefault(user, origin);
            set.add(time);
            map.put(user, set);
        }
        System.out.println(map);
        int[] res = new int[k];
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            int userMinCnt = entry.getValue().size();
            res[--userMinCnt]++;
        }
        return res;
    }

    /**
     * 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
     * <p>
     * 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
     * <p>
     * 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
     * <p>
     * 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。
     *
     * @param nums1
     * @param nums2
     * @return
     */

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        // 寻找需要替换的元素
        // [1,7,5]
        // [2,3,5]
        // 1. 不替换的结果
        int res1 = 0;
        for (int i = 0; i < nums1.length; i++) {
            res1 += calcABS(nums1[i], nums2[i]);
        }

        // 2. 替换
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            int maxAffect = Integer.MIN_VALUE;
            int j = 0;
            for (; j < nums2.length && j != i; j++) {
                // 本来是 nums1 第 j 个替换 nums2 第 j 个
                int absOrigin = calcABS(nums1[j], nums2[j]);
                // 现在 nums1 第 i 个 替换 nums2 第 j 个
                int absAfter = calcABS(nums1[i], nums2[j]);
                if (absAfter < absOrigin) {
                    int affect = absOrigin - absAfter;
                    maxAffect = Math.max(maxAffect, affect);
                }
            }
            if (maxAffect > 0) {
                temp.add(maxAffect);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i: temp) {
            max = Math.max(max, i);
        }

        if (max > 0) {
            return (int) ((res1 - max) % (Math.pow(10, 9) + 7));
        }
        return (int) (res1 % (Math.pow(10, 9) + 7));
    }

    /**
     * 给你一个由正整数组成的数组 nums 。
     *
     * 数字序列的 最大公约数 定义为序列中所有整数的共有约数中的最大整数。
     *
     * 例如，序列 [4,6,16] 的最大公约数是 2 。
     * 数组的一个 子序列 本质是一个序列，可以通过删除数组中的某些元素（或者不删除）得到。
     *
     * 例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。
     * 计算并返回 nums 的所有 非空 子序列中 不同 最大公约数的 数目 。
     */
    public int countDifferentSubsequenceGCDs(int[] nums) {

    }

    private int calcABS(int a, int b) {
        int res = a - b;
        return res < 0 ? -res : res;
    }
}
