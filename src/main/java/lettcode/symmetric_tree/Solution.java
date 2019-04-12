package lettcode.symmetric_tree;

import java.util.LinkedList;

/**
 * #101 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        System.out.println(isSymmetric(treeNode));
        System.out.println(isSymmetric1(treeNode));

    }


    /**
     * 递归
     *   先排除特殊情况,子节点为空
     *   对后续节点进行镜像判断
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    /**
     * 判断是否为镜像
     */
    public static boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return (root1.val == root2.val)
                && isMirror(root1.left, root2.right)
                && isMirror(root1.right, root2.left);
    }

    /**
     * 递归
     */
    public static boolean isSymmetric1(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode root1 = list.poll();
            TreeNode root2 = list.poll();

            if (root1 == null && root2 == null) {
                continue;
            }

            if (root1 == null || root2 == null) {
                return false;
            }

            if (root1.val != root2.val) {
                return false;
            }

            list.add(root1.left);
            list.add(root2.right);
            list.add(root1.right);
            list.add(root2.left);
        }

        return true;
    }


}
