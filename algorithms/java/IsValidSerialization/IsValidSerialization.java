// Source : https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
// Author : cornprincess
// Date   : 2021-03-13

/***************************************************************************************************** 
 *
 * One way to serialize a binary tree is to use preorder traversal. When we encounter a non-null node, 
 * we record the node's value. If it is a null node, we record using a sentinel value such as '#'.
 *
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", 
 * where '#' represents a null node.
 *
 * Given a string of comma-separated values preorder, return true if it is a correct preorder 
 * traversal serialization of a binary tree.
 *
 * It is guaranteed that each comma-separated value in the string must be either an integer or a 
 * character '#' representing null pointer.
 *
 * You may assume that the input format is always valid.
 *
 * 	For example, it could never contain two consecutive commas, such as "1,,3".
 *
 * Example 1:
 * Input: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Output: true
 * Example 2:
 * Input: preorder = "1,#"
 * Output: false
 * Example 3:
 * Input: preorder = "9,#,#,1"
 * Output: false
 *
 * Constraints:
 *
 * 	1 <= preorder.length <= 104
 * 	preoder consist of integers in the range [0, 100] and '#' separated by commas ','.
 *
 * Follow up: Find an algorithm without reconstructing the tree.
 ******************************************************************************************************/
package IsValidSerialization;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhoutianbin
 * @date 2021/3/13 10:55 AM
 */
public class IsValidSerialization {

    // 使用栈，二叉树的遍历可以用递归，当用迭代是可以使用栈来代替递归
    public boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int i = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        while (i < n) {
            if (stack.isEmpty()) {
                return false;
            }
            // core 核心判断逻辑
            // 如果遇到逗号就跳过
            if (preorder.charAt(i) == ',') {
                i++;
                // 如果遇到 #
            } else if (preorder.charAt(i) == '#') {
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                i++;
                // 如果遇到数字
            } else {
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }

    /* core 使用出度和入度，二叉树可以看成是一个有向图
     *         root
     *           |
     *         |   |
     *         0   #
     *
     * 对于根节点：提供2个出度，0个入度
     * 对于正常子节点的：提供2个出度，一个入度
     * 对于空子节点：提供0个出度，1个入度
     *
     * 判断条件：
     *  在遍历过程中，必定是 出度 < 入度，如果不是，那么就为false
     *  遍历结束后，判断 初度 是否 等于 入度
     *
     */
    public boolean isValidSerialization2(String preorder) {
        // special case
        if ("#".equals(preorder)) {
            return true;
        }

        // ##1 这种就是非法的
        if (preorder.charAt(0) == '#') {
            return false;
        }
        int indegree = 0;
        int outdegree = 2;

        // core 这里一定要转为数组才行
        String[] strings = preorder.split(",");
        // 前序遍历中，第一个点肯定是root，从第二个点开始遍历
        for (int i = 1; i < strings.length; i++) {
            if ("#".equals(strings[i])) {
                indegree++;
            } else {
                indegree++;
                outdegree += 2;
            }
            if (i != strings.length - 1 && indegree >= outdegree) {
                return false;
            }
        }
        return indegree == outdegree;
    }

    // 栈的思想
    /* core
     * 官方题解给出了槽位的概念，相当于占坑，一个节点要想进来必须消耗一个当前的槽位，即出度
     *  根节点：提供两个原始的槽位
     *  空节点：消耗一个槽位
     *  非空节点：消耗一个槽位，然后增加两个槽位
     *
     * 栈：栈中的元素表示对应节点处剩余槽位的数量，栈顶元素表示对应下一步可用的槽位数量，无论何时当栈顶元素变为0后，要将栈顶元素弹出
     */
    public boolean isValidSerialization3(String preorder) {
        // core 这里要注意两个特例
        // 1. "#" 返回 true
        // 2. "9,3,4,#,#,1,#,#,#,2,#,6,#,#" 这种是森林，返回false
        // 森领：9,3,4,#,#,1,#,# 为二叉树，2,#,6,#,#为二叉树，"9,3,4,#,#,1,#,#,#,2,#,6,#,#" 即为森林
        if ("#".equals(preorder)) {
            return true;
        }

        Deque<Integer> stack = new LinkedList<>();
        String[] strings = preorder.split(",");
        for (int i = 0; i < strings.length; i++) {
            if (!"#".equals(strings[i])) {
                stack.push(2);
            } else {
                if (!stack.isEmpty()) {
                    int temp = stack.pop() - 1;
                    if (temp == 0) {
                        while (!stack.isEmpty()) {
                            int t = stack.pop() - 1;
                            if (t != 0) {
                                stack.push(t);
                                break;
                            }
                        }
                    } else {
                        stack.push(temp);
                    }
                } else {
                    return false;
                }
                // 防止出现 "9,3,4,#,#,1,#,#,#,2,#,6,#,#" 这种是森林，返回false
                if (i != strings.length - 1 && stack.isEmpty()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
