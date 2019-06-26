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
     *
     * @param l1 单向链表
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.getVal() : 0;
            int y = (q != null) ? q.getVal() : 0;
            int sum = carry + x + y;
            carry = sum / 10;

            ListNode listNode = curr.getNext();

            listNode = new ListNode(sum % 10);
            curr = curr.getNext();
            if (p != null){
                p = p.getNext();
            }

            if (q != null) {
                q = q.getNext();
            }
        }
        if (carry > 0) {
            ListNode listNode2 = curr.getNext();

            listNode2 = new ListNode(carry);
        }
        return dummyHead.getNext();
    }



}
