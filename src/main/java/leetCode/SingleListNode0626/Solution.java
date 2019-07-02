package leetCode.SingleListNode0626;

import entity.ListNode;

/**
 * Definition for singly-linked list.
 *
 * @author zangtao
 * @create 2019 - 06 -26 18:43
 */
public class Solution {

    /**
     * Definition for singly-linked list.
     * @return
     */
    public final static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //生命一个空的链表
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);

        ListNode listNode2 = new ListNode(3);


        listNode.next = listNode2;

        listNode2.next = new ListNode(4);

        ListNode listNode3 = new ListNode(0);

        ListNode listNode4 = new ListNode(7);

        listNode3.next = listNode4;

        listNode4.next = new ListNode(5);

        ListNode ln = addTwoNumbers(listNode, listNode3);

        ListNode ln1 = new ListNode();

        System.out.println(ln.val);
        System.out.println(ln.next.val);

        ln1 = ln.next;

        System.out.println(ln1.next.val);

        System.out.println(ln1.next.next.val);

    }

}
