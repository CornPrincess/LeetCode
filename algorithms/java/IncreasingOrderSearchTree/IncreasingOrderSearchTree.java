// Source : https://leetcode.com/problems/increasing-order-search-tree/
// Author : cornprincess
// Date   : 2021-04-25

/***************************************************************************************************** 
 *
 * Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in 
 * the tree is now the root of the tree, and every node has no left child and only one right child.
 *
 * Example 1:
 *
 * Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 * Example 2:
 *
 * Input: root = [5,1,7]
 * Output: [1,null,5,null,7]
 *
 * Constraints:
 *
 * 	The number of nodes in the given tree will be in the range [1, 100].
 * 	0 <= Node.val <= 1000
 ******************************************************************************************************/

package IncreasingOrderSearchTree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class IncreasingOrderSearchTree {

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        TreeNode temp = dummy;
        Deque<TreeNode> stack = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode curr = stack.pop();
            list.add(curr);
            root = curr.right;
        }

        for (TreeNode node : list) {
            temp.right = node;
            node.left = null;
            temp = node;
        }
        return dummy.right;
    }

    public TreeNode increasingBST2(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        TreeNode temp = dummy;

        List<TreeNode> list = new ArrayList<>();
        recursive(root, list);
        for (TreeNode node : list) {
            temp.right = node;
            node.left = null;
            temp = node;
        }
        return dummy.right;
    }

    private void recursive(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }

        recursive(root.left, list);
        list.add(root);
        recursive(root.right, list);
    }
}
