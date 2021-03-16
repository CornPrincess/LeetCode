package GroupAnagrams;

import org.junit.Test;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-04-07
 * Time: 21:04
 */
public class GroupAnagramsTest {
    private GroupAnagrams groupAnagrams = new GroupAnagrams();
    private String[] testcase = {"eat", "tea", "tan", "ate", "nat", "bat"};

    @Test
    public void sortedKeyHashMap_test() {
        List<List<String>> lists = groupAnagrams.sortedKeyHashMap(testcase);
        for (List<String> value: lists) {
            System.out.println(value);
        }
    }

    @Test
    public void countedKeyHashMap_test() {
        List<List<String>> lists = groupAnagrams.countedKeyHashMap(testcase);
        for (List<String> value: lists) {
            System.out.println(value);
        }
    }
}
