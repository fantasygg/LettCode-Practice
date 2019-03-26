package lettcode.univalued_binary_tree;

import java.util.HashSet;

/**
 * #965 单值二叉树
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 *
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 *
 * 示例 1：
 *
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 * 示例 2：
 *
 * 输入：[2,2,2,5,2]
 * 输出：false
 *
 * 提示：
 *
 * 给定树的节点数范围是 [1, 100]。
 * 每个节点的值都是整数，范围为 [0, 99] 。
 */
public class Solution {

    private static HashSet<Integer> set;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(2);

        System.out.println(isUnivalTree(root));
        System.out.println(isUnivalTree1(root));
    }

    /**
     * (1)
     * 利用 HashSet 元素不重复的特性
     * 注意:这里的set要在方法内部初始化,否则不能通过lettcode的测试用例
     */
    public static boolean isUnivalTree(TreeNode root) {
        set = new HashSet<>();
        add(root);
        return set.size() == 1;
    }


    /**
     * (2)
     * 使用递归实现
     */
    public static boolean isUnivalTree1(TreeNode root) {
        boolean left = false;
        boolean right = false;

        if (root.left == null || ((root.val == root.left.val) && isUnivalTree1(root.left))) {
            left =true;
        }

        if (root.right == null || (root.val == root.right.val && isUnivalTree1(root.right))) {
            right = true;
        }

        return left && right;
    }

    private static void add(TreeNode node) {
        if (node != null) {
            set.add(node.val);
            add(node.left);
            add(node.right);
        }
    }

}
