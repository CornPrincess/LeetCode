package FindWordsThatCanBeFormedByCharacters;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-03-18
 * Time: 00:09
 */
public class FindWordsThatCanBeFormedByCharactersTest {
    private FindWordsThatCanBeFormedByCharacters findWordsThatCanBeFormedByCharacters = new FindWordsThatCanBeFormedByCharacters();

    @Test
    public void solution() {
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";

        int result = findWordsThatCanBeFormedByCharacters.solution(words, chars);
        Assert.assertEquals(6, result);
    }
}
