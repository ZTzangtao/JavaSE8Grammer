package entity;

/**
 * @Author Tommy
 * @Date 2022/3/21 9:49 AM
 * @Version 1.0
 */
public class ReverseList {

    public static ListNode iterate(ListNode head){
        ListNode prev = null;
        ListNode curr = null;
        ListNode next = null;
        curr = head;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
