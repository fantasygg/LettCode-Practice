package lettcode.delete_node_in_a_linkedList;

/**
 * #237
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 *
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 *
 * 输入: head = [4,5,1,9], node = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *
 *
 * 说明:
 *
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 *
 */
public class Solution {

    public static void main(String[] args) {

        ListNode firstNode = new ListNode(4);
        ListNode secondNode = new ListNode(5);
        firstNode.next = secondNode;
        ListNode thirdNode = new ListNode(1);
        secondNode.next = thirdNode;
        thirdNode.next =  new ListNode(9);

        deleteNode(secondNode);

        System.out.println(firstNode.val+"   "+firstNode.next.val+"  "+firstNode.next.next.val );
    }


    private static void deleteNode(ListNode node) {
        // 例如 ：4 5 1 9  传进来第2个节点

        // 1.  将当前节点的下一个节点的值 赋给当前节点
        node.val = node.next.val ;
        // 2.  将当前节点的下下个节点指向当前节点的下个节点
        node.next = node.next.next;

        // 经过第1步后 : 4 1 1 9
        // 经过第2步后:  4 1 9
    }

}
