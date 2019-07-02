package entity;


/**
 * 链表
 * Definition for singly-linked list.
 *
 *
 * @author zangtao
 * @create 2019 - 06 -26 15:10
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    public ListNode(){}

    public Integer getVal(){
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext(){
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }


}
