// Source : https://leetcode.com/problems/flatten-nested-list-iterator/
// Author : zhoutianbin
// Date   : 2021-03-23

/***************************************************************************************************** 
 *
 * Given a nested list of integers, implement an iterator to flatten it.
 * 
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * 
 * Example 1:
 * 
 * Input: [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Explanation: By calling next repeatedly until hasNext returns false, 
 *              the order of elements returned by next should be: [1,1,2,1,1].
 * 
 * Example 2:
 * 
 * Input: [1,[4,[6]]]
 * Output: [1,4,6]
 * Explanation: By calling next repeatedly until hasNext returns false, 
 *              the order of elements returned by next should be: [1,4,6].
 * 
 ******************************************************************************************************/

package FlattenNestedListIterator;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    private List<NestedInteger> nestedLists;
    private Deque<List<NestedInteger>> stack = new LinkedList<>();
    private int index = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedLists = nestedList;
    }

    @Override
    public boolean hasNext() {
        return this.index < nestedLists.size();
    }

    @Override
    public Integer next() {
        NestedInteger nestedInteger =  this.nestedLists.get(index);
        this.index++;

        if (nestedInteger.isInteger()) {
            return nestedInteger.getInteger();
        }

        List<NestedInteger> list = nestedInteger.getList();
    }

    // dfs
    // 如何记录当前遍历的是哪个list，最简单的方法就是使用栈来模拟递归
    public Integer next0(List<NestedInteger> list) {
        this.stack.push(list);

        for (NestedInteger ni : list) {
            if (ni.isInteger()) {
                return ni.getInteger();
            } else {
                stack.push(ni.getList());
            }
        }

        List<NestedInteger> list = nestedInteger.getList();
        NestedIterator it = new NestedIterator(list);
        while (it.hasNext()) {
//            return it.next0();
        }
        return -1;
    }
}