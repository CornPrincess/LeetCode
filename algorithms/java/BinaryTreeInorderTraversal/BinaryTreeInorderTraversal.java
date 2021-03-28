// Source : https://leetcode.com/problems/binary-tree-inorder-traversal/
// Author : cornprincess
// Date   : 2021-03-28

/***************************************************************************************************** 
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example 1:
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 *
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 *
 * Example 4:
 *
 * Input: root = [1,2]
 * Output: [2,1]
 *
 * Example 5:
 *
 * Input: root = [1,null,2]
 * Output: [1,2]
 *
 * Constraints:
 *
 * 	The number of nodes in the tree is in the range [0, 100].
 * 	-100 <= Node.val <= 100
 *
 * Follow up:
 *
 * Recursive solution is trivial, could you do it iteratively?
 *
 ******************************************************************************************************/

package BinaryTreeInorderTraversal;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    List<Integer> list = new ArrayList<>();
    Deque<TreeNode> stack = new LinkedList<>();

    // 递归
    // 时间复杂度：O(N) 每个节点都会被遍历一边且只会被遍历一次
    // 空间复杂度：O(N) 空间复杂度取决于栈深度，而栈深度在二叉树为一条链的情况下会达到 O(N) 的级别。
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return list;
    }

    // stack
    // 时间复杂度：O(N) 每个节点都会被遍历一边且只会被遍历一次
    // 空间复杂度：O(N) 空间复杂度取决于栈深度，而栈深度在二叉树为一条链的情况下会达到 O(N) 的级别。
    public List<Integer> inorderTraversal2(TreeNode root) {
        while (root != null || !stack.isEmpty()) {
            // 这里相当于模拟dfs，将所有的左节点一直push到stack中，直到为null
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    /**
     * Morris
     * <p>
     * Morris遍历算法是另一种遍历二叉树的方法，可以省去栈的空间占用
     * <p>
     * 其实整个过程的精髓为【标记的思想】：
     * 假设当前遍历到的节点为 x ，将 x 的左子树中最右边的节点节点的右孩子（即中序遍历中 x 前一个节点）指向 x
     * 这样在左子树遍历完成后，我们通过这个指向走回了 x，且能通过这个指向直销我们已经遍历完成了左子树，而不用在通过栈来进行维护
     * <p>
     * <p>
     * 假设当前遍历到的节点为 x
     * 如果 x 无左孩子，先将 x 的值加入答案数组，再访问 x 的右孩子， 即 x = x.right
     * 如果 x 有左孩子，则先找到 x 左子树上最右的节点（即左子树中序遍历的最后一个节点，x 在 中序遍历中的前驱节点
     *  如果 predecessor 的右孩子为空，则将其右孩子指向 x，然后访问 x 的左孩子，即 x = x.left。
     *  如果 predecessor 的右孩子不为空，则此时其右孩子指向 x，说明我们已经遍历完 x 的左子树，我们将 predecessor 的右孩子置空，将 x 的值加入答案数组，然后访问 x 的右孩子，即 x = x.right。
     *
     * 时间复杂度：O(2N) = O(N)
     * 空间复杂度：O(1)
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        TreeNode predecessor;
        while (root != null) {
            // 首先判断当前 x 是否有左孩子
            if (root.left != null) {
                // 如果存在左孩子，首先要找到 x 的 predecessor
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                // core 如果 predecessor还没有指向 x，进行链接标记 ，并且继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    // core 断开链接，将其值放入结果中，并且开始遍历 x 的右子树
                    list.add(root.val);
//                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                // 如果没有左孩子，直接将当前 x 的结果放入 list 中
                // 并且开始遍历其右孩子
                list.add(root.val);
                // core 因为之前已经链接过了，所以此时会直接跳到 root 的中序遍历的后继节点
                root = root.right;
            }
        }
        return list;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
