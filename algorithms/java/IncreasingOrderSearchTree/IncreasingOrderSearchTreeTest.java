package IncreasingOrderSearchTree;

import common.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 4/25/21
 * Time: 11:13 PM
 */
public class IncreasingOrderSearchTreeTest {

    private IncreasingOrderSearchTree increasingOrderSearchTree = new IncreasingOrderSearchTree();
    private TreeNode testcase = new TreeNode();

    @Before
    public void init() {
        TreeNode root = new TreeNode(5);
        TreeNode root_l = new TreeNode(3);
        TreeNode root_r = new TreeNode(6);
        root.left = root_l;
        root.right = root_r;
        TreeNode root_l_l = new TreeNode(2);
        TreeNode root_l_r = new TreeNode(4);
        root_l.left = root_l_l;
        root_l.right = root_l_r;
        TreeNode root_r_r = new TreeNode(8);
        root_r.right = root_r_r;
        TreeNode root_l_l_l = new TreeNode(1);
        root_l_l.left = root_l_l_l;
        TreeNode root_r_r_l = new TreeNode(7);
        TreeNode root_r_r_r = new TreeNode(9);
        root_r_r.left = root_r_r_l;
        root_r_r.right = root_r_r_r;
        testcase = root;
    }

    @Test
    public void increasingBST() {
        TreeNode.inorder(testcase);
        System.out.println();
        TreeNode ans = increasingOrderSearchTree.increasingBST(testcase);
        TreeNode.inorder(ans);
    }

    @Test
    public void increasingBST2() {
        TreeNode.inorder(testcase);
        System.out.println();
        TreeNode ans = increasingOrderSearchTree.increasingBST2(testcase);
        TreeNode.inorder(ans);
    }
}
