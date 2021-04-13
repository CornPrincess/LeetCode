// Source : https://leetcode.com/problems/minimum-distance-between-bst-nodes/
// Author : cornprincess
// Date   : 2021-04-13

/***************************************************************************************************** 
 *
 * Given the root of a Binary Search Tree (BST), return the minimum difference between the values of 
 * any two different nodes in the tree.
 *
 * Note: This question is the same as 530: 
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 *
 * Example 1:
 *
 * Input: root = [4,2,6,1,3]
 * Output: 1
 *
 * Example 2:
 *
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 *
 * Constraints:
 *
 * 	The number of nodes in the tree is in the range [2, 100].
 * 	0 <= Node.val <= 105
 ******************************************************************************************************/

package MinimumDistanceBetweenBstNodes;

import common.TreeNode;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MinimumDistanceBetweenBstNodes {
    List<Integer> inOrder = new ArrayList<>();

    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < inOrder.size() - 1; i++) {
            ans = Math.min((inOrder.get(i + 1) - inOrder.get(i)), ans);
        }
        return ans;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        inOrder.add(root.val);
        inOrder(root.right);
    }

    public void inOrderByStack(TreeNode root) {
        TreeNode curr = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            if (!stack.isEmpty()) {
                curr = stack.pop();
                inOrder.add(curr.val);
                curr = curr.right;
            }
        }
    }
}
