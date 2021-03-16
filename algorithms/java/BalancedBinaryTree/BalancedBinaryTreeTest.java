package BalancedBinaryTree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-08-17
 * Time: 23:05
 */
public class BalancedBinaryTreeTest {

    private TreeNode treeNode;
    private BalancedBinaryTree balancedBinaryTree;

    @Before
    public void setUpTreeNode() {
        balancedBinaryTree = new BalancedBinaryTree();
        treeNode = new TreeNode(1);
        TreeNode treeNode21 = new TreeNode(21);
        TreeNode treeNode22 = new TreeNode(22);
        TreeNode treeNode31 = new TreeNode(31);
        TreeNode treeNode32 = new TreeNode(32);
        TreeNode treeNode33 = new TreeNode(33);
        TreeNode treeNode34 = new TreeNode(34);
        TreeNode treeNode41 = new TreeNode(41);
        treeNode.left = treeNode21;
        treeNode.right = treeNode22;
        treeNode21.left = treeNode31;
        treeNode21.right = treeNode32;
        treeNode22.left = treeNode33;
        treeNode22.right = treeNode34;
        treeNode31.left = treeNode41;
    }

    @Test
    public void height_test() {
        int height = balancedBinaryTree.height(treeNode);
        Assert.assertEquals(4, height);
    }

    @Test
    public void isBalanced_test() {
        boolean isBalanced = balancedBinaryTree.isBalanced(treeNode);
        boolean isBalanced2 = balancedBinaryTree.isBalanced2(treeNode);
        Assert.assertTrue(isBalanced);
        Assert.assertTrue(isBalanced2);
    }
}
