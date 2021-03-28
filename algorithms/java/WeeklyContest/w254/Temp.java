package WeeklyContest.w254;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhoutianbin
 * @date 2021/3/28 10:33 AM
 */
public class Temp {
    /*
     * 5713. 字符串中不同整数的数目 显示英文描述
通过的用户数2520
尝试过的用户数3047
用户总通过次数2536
用户总提交次数7143
题目难度Easy
给你一个字符串 word ，该字符串由数字和小写英文字母组成。

请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。注意，剩下的这些整数间至少要用一个空格隔开："123"、"34"、"8" 和 "34" 。

返回对 word 完成替换后形成的 不同 整数的数目。

如果两个整数的 不含前导零 的十进制表示不同，则认为这两个整数也不同。
     */
    List<Integer> num = new ArrayList<>();
    List<Integer> nums = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    public int numDifferentIntegers(String word) {
        if (word == null || word.length() == 0) {
            return 0;
        }
        // a123fg12gf5
        for (Character c: word.toCharArray()) {
            if (!Character.isDigit(c)) {
                if (num.size() > 0) {
                    nums.add(toDigit());
                    num.clear();
                }
            } else {
                num.add(c - '0');
            }
        }
        if (num.size() > 0) {
            nums.add(toDigit());
        }

        set.addAll(nums);
        return set.size();
    }

    private int toDigit() {
        int res = 0;
        int start = 0;
        // 0089
        while (start < num.size() && num.get(start) == 0) {
            start++;
        }
        for (; start < num.size(); start++) {
            res = res * 10 + num.get(start);
        }
        return res;
    }
}
