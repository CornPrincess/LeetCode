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

    // Morris
    public List<Integer> inorderTraversal3(TreeNode root) {

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
