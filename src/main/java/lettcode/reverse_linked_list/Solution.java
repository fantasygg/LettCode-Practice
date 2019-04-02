package lettcode.reverse_linked_list;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/solution/
 *
 * #206 翻转链表
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(reverseList(head).val);

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        System.out.println(reverseList1(head1).val);
    }

    /**
     * 迭代方法
     */
    public static ListNode reverseList(ListNode head) {
        ListNode reverseNode = null;
        while (head != null) {
            // 临时节点 存放当前节点的下一个节点
            ListNode temp = head.next;

            // 当前节点的指针翻转
            head.next = reverseNode;

            // 当前节点赋值给翻转的节点
            reverseNode = head;

            // 改变当前节点
            head = temp;
        }
        return reverseNode;
    }


    /**
     * 递归方法
     */
    public static ListNode reverseList1(ListNode head) {
        if (head.next == null) {
            // 到达末尾
            return head;
        }
        // 递归调用下一个节点的反转方法
        ListNode reverseNode = reverseList1(head.next);
        // 此节点的下下个节点置为当前节点,形成一个环型
        head.next.next = head;
        // 将当前节点的下一个节点置空,断开环
        head.next = null;
        // 成功反转此节点
        // 返回此节点
        return reverseNode;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
