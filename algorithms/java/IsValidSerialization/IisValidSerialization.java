package IsValidSerialization;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhoutianbin
 * @date 2021/3/13 10:55 AM
 */
public class IisValidSerialization {

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
        // 前序遍历中，第一个点肯定是root，从第二个点开始遍历
        for (int i = 1; i < preorder.length(); i++) {
            if (preorder.charAt(i) == '#') {
                indegree++;
            } else if (preorder.charAt(i) != ','){
                indegree++;
                outdegree += 2;
            }
            if (i != preorder.length() - 1 && indegree >= outdegree) {
                return false;
            }
        }
        return indegree == outdegree;
    }
}
