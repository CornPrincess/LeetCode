package DistinctSubsequences;

import org.junit.Test;

/**
 * @author zhoutianbin
 * @date 2021/3/17 10:59 AM
 */
public class DistinctSubsequencesTest {
    private DistinctSubsequences distinctSubsequences = new DistinctSubsequences();

    @Test
    public void numDistinct() {
        final int i = distinctSubsequences.numDistinct("rabbbit", "rabbit");
        System.out.println(i);
        System.out.println(distinctSubsequences.numDistinct2("rabbbit", "rabbit"));
    }
}