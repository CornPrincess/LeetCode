package WeeklyContest.w254;

/**
 * @author zhoutianbin
 * @date 2021/3/28 11:04 AM
 */

/*
 * 5715. 还原排列的最少操作步数 显示英文描述
通过的用户数1085
尝试过的用户数1321
用户总通过次数1091
用户总提交次数1554
题目难度Medium
给你一个偶数 n​​​​​​ ，已知存在一个长度为 n 的排列 perm ，其中 perm[i] == i​（下标 从 0 开始 计数）。

一步操作中，你将创建一个新数组 arr ，对于每个 i ：

如果 i % 2 == 0 ，那么 arr[i] = perm[i / 2]
如果 i % 2 == 1 ，那么 arr[i] = perm[n / 2 + (i - 1) / 2]
然后将 arr​​ 赋值​​给 perm 。

要想使 perm 回到排列初始值，至少需要执行多少步操作？返回最小的 非零 操作步数。
 */
public class Temp2 {
    // perm: 0, 1, 2, 3, 4, 5
    // arr : 0, 3, 1, 4, 2, 5
    public int reinitializePermutation(int n) {
        return -1;
    }
}
