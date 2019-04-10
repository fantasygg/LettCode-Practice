package lettcode.trim_a_binary_search_tree;

/**
 * #669 修剪二叉搜索树
 * https://leetcode-cn.com/problems/trim-a-binary-search-tree/
 * <p>
 * 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 *      1
 *     / \
 *    0   2
 * <p>
 * L = 1
 * R = 2
 * <p>
 * 输出:
 *      1
 *        \
 *          2
 * 示例 2:
 * <p>
 * 输入:
 *          3
 *         / \
 *        0   4
 *          \
 *           2
 *          /
 *         1
 * <p>
 * L = 1
 * R = 3
 * <p>
 * 输出:
 *         3
 *        /
 *      2
 *     /
 *    1
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = null;
        node.right = new TreeNode(2);
        System.out.println(trimBST(node,1,2).val);
    }

    /**
     * 递归
     * 解题思路：
     *      从根节点开始判断大小，比L小或者比R大的值就减去
     *      比R大，返回左节点递归后的节点;比L小，返回右节点递归后的值
     *      在L,R之间的话，递归的判断左右节点的值
     */
    public static TreeNode trimBST(TreeNode root, int L, int R) {

        if (root == null){
            return null;
        }

        if (root.val > R) {
            return trimBST(root.left,L,R);
        }

        if (root.val < L){
            return trimBST(root.right,L,R);
        }

        root.right = trimBST(root.right,L,R);
        root.left = trimBST(root.left,L,R);

        return root;
    }
}
