package FlattenNestedListIterator;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 3/23/21
 * Time: 11:29 PM
 */
public class NestedIterator2 implements Iterator<Integer> {

    private Deque<Iterator<NestedInteger>> stack;

    // 所有的迭代都是可以使用栈来代替的，因此dfs也可以使用栈来代替
    // 这种解法很精妙，一定要掌握
    public NestedIterator2(List<NestedInteger> nestedList) {
        // core 这里是关键：栈中存放的是迭代器，能想到这里题目就做出来一大半了
        // core 栈中存放迭代器，可以解决当前遍历到那个变量的问题
        stack = new LinkedList<>();
        stack.push(nestedList.iterator());
    }

    // todo 均摊时间复杂度为 O(1)
    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (!stack.peek().hasNext()) {
                stack.pop();
                // core 这里一定要 continue，表示当前迭代器已经遍历完了，必须重新判断一遍栈是否为空
                continue;
            }
            NestedInteger next = stack.peek().next();
            if (next.isInteger()) {
                List<NestedInteger> list = new ArrayList<>();
                list.add(next);
                stack.push(list.iterator());
                return true;
            }
            stack.push(next.getList().iterator());
        }
        return false;
    }

    @Override
    public Integer next() {
        return stack.peek().next().getInteger();
    }
}
