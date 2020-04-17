package leetCode.node;

import lombok.Data;

import java.util.concurrent.*;

/**
 * @author zangtao
 * @date 2020/4/10 9:27
 */
@Data
public class ListNode {

    private int val;

    private ListNode next;

    private ListNode (int x){
        val = x;
    }


}
