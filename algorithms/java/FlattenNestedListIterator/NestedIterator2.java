package FlattenNestedListIterator;

import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 3/23/21
 * Time: 11:29 PM
 */
public class NestedIterator2 implements Iterator<Integer> {

    // 所有的迭代都是可以使用栈来代替的，因此dfs也可以使用栈来代替
    // 这种解法很精妙，一定要掌握
    // core todo
    public NestedIterator2(List<NestedInteger> nestedList) {
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        return null;
    }
}
