package BinarySearchTreeIterator;

import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhoutianbin
 * @date 2021/3/28 10:30 AM
 */
public class BSTIteratorTest {
    @Test
    public void test() {
        BSTIterator bstIterator = new BSTIterator(init());
        bstIterator.test();
    }

    private TreeNode init() {
        TreeNode root = new TreeNode(7);
        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(15);
        TreeNode right1_1 = new TreeNode(9);
        TreeNode right1_2 = new TreeNode(20);

        root.left = left1;
        root.right = right1;
        right1.left = right1_1;
        right1.right = right1_2;

        return root;
    }
}