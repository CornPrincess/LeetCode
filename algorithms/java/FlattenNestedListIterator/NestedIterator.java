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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    private List<Integer> list = new ArrayList<>();
    private int index = 0;

    // core 一种解题思路，使用DFS算法将整个集合进行摊平处理，
    // 摊平的所有数据都放在内部的 list 中，然后再对这个 list 进行 hasNext 和 next 的开发
    // 时间复杂度：初始化 O(n) hasNext next 都为 O(1)
    // 空间复杂度：O(n)
    public NestedIterator(List<NestedInteger> nestedList) {
        for (NestedInteger ni : nestedList) {
            init(ni);
        }
    }

    private void init(NestedInteger ni) {
        if (ni.isInteger()) {
            this.list.add(ni.getInteger());
        }

        for (NestedInteger tni : ni.getList()) {
            init(tni);
        }
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public Integer next() {
        return this.list.get(index++);
    }

}
