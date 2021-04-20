package ImplementStrstr;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhoutianbin
 * @date 2021/4/20 10:07 AM
 */
public class ImplementStrstrTest {
    private ImplementStrstr implementStrstr = new ImplementStrstr();

    @Test
    public void strStr() {
        String hayStack = "mississippi";
        String needle = "issipi";
        implementStrstr.strStr(hayStack, needle);
    }

    @Test
    public void strStr2() {
        String hayStack = "hello";
        String needle = "ll";
        implementStrstr.strStr(hayStack, needle);
    }
}