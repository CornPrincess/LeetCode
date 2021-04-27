// Source : https://leetcode-cn.com/problems/range-sum-of-bst/
// Author : cornprincess
// Date   : 2021-04-27

/***************************************************************************************************** 
 *
 * Given the root node of a binary search tree, return the sum of values of all nodes with a value in 
 * the range [low, high].
 * 
 * Example 1:
 * 
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 * 
 * Example 2:
 * 
 * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * Output: 23
 * 
 * Constraints:
 * 
 * 	The number of nodes in the tree is in the range [1, 2 * 104].
 * 	1 <= Node.val <= 105
 * 	1 <= low <= high <= 105
 * 	All Node.val are unique.
 ******************************************************************************************************/

package RangeSumOfBst;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class RangeSumOfBst {
    // inorder-iterator
    public int rangeSumBST(TreeNode root, int low, int high) {
        int ans = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode curr = stack.pop();
            if (curr.val >= low && curr.val <= high) {
                ans += curr.val;
            }
            root = curr.right;
        }
        return ans;
    }

    // inorder-iterator - purning
    public int rangeSumBSTPruning(TreeNode root, int low, int high) {
        int ans = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                // purning 根据BST的特性，左子树所有的值都会小于low
                if (root.val < low) {
                    break;
                }
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode curr = stack.pop();
                // core purning
                if (curr.val > high) {
                    break;
                }
                if (curr.val >= low && curr.val <= high) {
                    ans += curr.val;
                }
                root = curr.right;
            }
        }
        return ans;
    }

    int ans_recur = 0;
    int low = 0;
    int high = 0;
    // inorder-recursive
    public int rangeSumBST2(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        recursive(root);
        return ans_recur;
    }

    private void recursive(TreeNode root) {
        if (root == null) {
            return;
        }

        recursive(root.left);
        if (root.val >= low && root.val <= high) {
            ans_recur += root.val;
        }
        recursive(root.right);
    }

    // dfs
    public int rangeSumBST3(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBST3(root.left, low, high);
        } else if (root.val < low) {
            return rangeSumBST3(root.right, low, high);
        } else {
            return root.val + rangeSumBST3(root.left, low, high) + rangeSumBST3(root.right, low, high);
        }
    }

    // bfs
    public int rangeSumBST4(TreeNode root, int low, int high) {
        Queue<TreeNode> queue  = new LinkedList<>();
        queue.add(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                continue;
            }
            if (curr.val > high) {
                queue.add(curr.left);
            } else if (curr.val < low) {
                queue.add(curr.right);
            } else {
                ans += curr.val;
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        return ans;
    }
}
