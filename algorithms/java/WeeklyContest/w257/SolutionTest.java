package WeeklyContest.w257;

import org.junit.Test;

import java.util.*;

/**
 * @author zhoutianbin
 * @date 2021/4/25 2:38 PM
 */
public class SolutionTest {
    // ************ 1 *************
    @Test
    public void test1() {
        System.out.println(toKRadix(579, 8));
        System.out.println(sumBase(34, 6));
    }

    public int sumBase(int n, int k) {
        // 1. 将十进制转化为k进制
        List<Integer> temp = toKRadix(n, k);
        // 2. 计算
        int ans = 0;
        for (int i : temp) {
            ans += i;
        }
        return ans;
    }

    private List<Integer> toKRadix(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        // 579 8
        while (n != 0) {
            temp.add(n % k);
            n = n / k;
        }
        Collections.reverse(temp);
        return temp;
    }

    // ************* 2 ****************
    @Test
    public void test2() {
        int[] nums = {1, 4, 8, 13};
        int k = 5;
        System.out.println(maxFrequency(nums, k));
    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        // 最小是1
        int ans = 1;
        // 排序之后每个数都有机会
        for (int i = 1; i < nums.length; i++) {
            int temp = 1;
            int tempk = k;
            for (int j = i - 1; j >= 0; j--) {
                if ((nums[i] - nums[j]) <= tempk) {
                    temp++;
                    tempk = tempk - (nums[i] - nums[j]);
                } else {
                    break;
                }
            }
            ans = Math.max(ans, temp);
        }
        return ans;
    }

    // ***************** 3 ****************
    @Test
    public void test3() {
        String word = "aeiaaioaaaaeiiiiouuuooaauuaeiu";
        System.out.println(longestBeautifulSubstring(word));
    }

    public int longestBeautifulSubstring(String word) {
        // aeiou
        // "aeiaaioaaaaeiiiiouuuooaauuaeiu"
        if (word.length() < 5) {
            return 0;
        }
        int ans = 0;
        int start = 0;
        int end = word.length() - 1;
        while (start < end) {
            int[] temp = longestBeautifulSubstring0(word, start, end);
            start = temp[0] + 1;
            ans = Math.max(ans, temp[1]);
        }
        return ans;
    }

    // 返回符合要求的
    private int[] longestBeautifulSubstring0(String word, int start, int end) {
        int ans = 0;
        int index = start;
        // 1. 寻找 a
        while (word.charAt(index) != 'a') {
            index++;
            if (index > end) {
                return new int[]{end, 0};
            }
        }

        int vaildStart = index;
        int pre = index;
        int curr = index + 1;
        Map<Character, List<Character>> compare = new HashMap<>();
        List<Character> a = new ArrayList<>();
        a.add('a');
        a.add('e');
        List<Character> e = new ArrayList<>();
        e.add('e');
        e.add('i');
        List<Character> i = new ArrayList<>();
        i.add('i');
        i.add('o');
        List<Character> o = new ArrayList<>();
        o.add('o');
        o.add('u');
        List<Character> u = new ArrayList<>();
        u.add('u');
        compare.put('a', a);
        compare.put('e', e);
        compare.put('i', i);
        compare.put('o', o);
        compare.put('u', u);

        // 2 判断 a 的后缀
        // "aeiaaioaaaaeiiiiouuuooaauuaeiu"
        // pre a
        // curr a
        while (curr <= end) {
            char dig = word.charAt(pre);
            if (compare.get(dig).contains(word.charAt(curr))) {
                pre++;
                curr++;
            } else {
                break;
            }
        }
        if (word.charAt(pre) == 'u') {
            ans = pre - vaildStart + 1;
        }
        return new int[]{pre, ans};
    }
}
