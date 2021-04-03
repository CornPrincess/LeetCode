package LongestCommonSubsequence;

import common.ListNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zhoutianbin
 * @date 2021/4/3 10:31 AM
 */
public class LongestCommonSubsequenceTest {
    private LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();

    @Test
    public void longestCommonSubsequence() {
    }

    @Test
    public void findSubSequence() {
        String testcase = "test";
        longestCommonSubsequence.findSubSequence(testcase, 0);
        System.out.println(longestCommonSubsequence.strings);
    }

    @Test
    public void test() {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.length());
        System.out.println(sb.toString());
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}