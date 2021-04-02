package PalindromeLinkedList;

import common.ListNode;
import common.ListNodeUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author zhoutianbin
 * @date 2021/4/2 11:31 AM
 */
public class PalindromeLinkedListTest {
    private PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();

    @Test
    public void isPalindrome() {
        ListNode testcase = new ListNode(1);
        ListNode point2 = new ListNode(1);
        ListNode point3 = new ListNode(2);
        ListNode point4 = new ListNode(1);
        testcase.next = point2;
        point2.next = point3;
        point3.next = point4;
        final boolean palindrome = palindromeLinkedList.isPalindrome(testcase);
        System.out.println(palindrome);
    }

    @Test
    public void test() {
        int[] nums = {1,2,3,4,5,6};
        ListNode test = ListNodeUtils.createByIterator(nums);
        ListNodeUtils.print(test);
        final int[] ints = Arrays.copyOfRange(nums, 0, 0);
        System.out.println(Arrays.toString(ints));
        System.out.println(ints.length);
        ListNode test2 = ListNodeUtils.createByRecursive(nums);
        ListNodeUtils.print(test2);
    }

    @Test
    public void isPalindrome2() {
        int[] nums = {1,2,1,1};
        ListNode testcase = ListNodeUtils.createByRecursive(nums);
        final boolean palindrome = palindromeLinkedList.isPalindrome3(testcase);
        System.out.println(palindrome);
    }

}