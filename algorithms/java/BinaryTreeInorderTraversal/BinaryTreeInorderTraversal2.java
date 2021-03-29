package BinaryTreeInorderTraversal;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 3/29/21
 * Time: 10:33 PM
 */
public class BinaryTreeInorderTraversal2 {
    List<Integer> list = new ArrayList<>();
    Deque<TreeNode> stack = new LinkedList<>();

    // 练习使用栈
    public List<Integer> inorderTraversal(TreeNode root) {
        while (root != null || !stack.isEmpty()) {
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

    // 练习使用 Morris
    public List<Integer> inorderTraversal2(TreeNode root) {
        TreeNode predecessor;
        while (root != null) {
            // 如果左孩子不为null
            if (root.left != null) {
                // 建立链接
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                // 取值，并断开链接
                if (predecessor.right != null) {
                    list.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                } else {
                    predecessor.right = root;
                    root = root.left;
                }

                root = root.left;
            } else {
                // 添加该节点的值
                list.add(root.val);
                // 开始遍历右子树
                root = root.right;
            }
        }
        return list;
    }
}
