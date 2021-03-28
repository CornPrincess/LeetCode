package BinaryTreeInorderTraversal;

import common.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 3/28/21
 * Time: 11:46 PM
 */
public class BinaryTreeInorderTraversalTest {
    private BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();

    @Test
    public void inorderTraversal3() {
        TreeNode root = init();
        root.inorder(root);
        List<Integer> list = binaryTreeInorderTraversal.inorderTraversal3(root);
        System.out.println(list);
    }

    private TreeNode init() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode left1_1 = new TreeNode(4);
        TreeNode left1_2 = new TreeNode(5);
        TreeNode right1_1 = new TreeNode(6);
        root.left = left;
        root.right = right;
        left.left = left1_1;
        left.right = left1_2;
        right.left = right1_1;
        return root;
    }
}
