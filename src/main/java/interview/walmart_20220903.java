package interview;

import com.alibaba.fastjson.JSON;
import entity.ListNode;

import java.util.*;

/**
 * @Author: Tommy
 * @DATE: 2022/9/3
 * @Description: 练习
 */
public class walmart_20220903 {

    public static void main(String[] args) {
//        int[][] requestArray = new int[][]{{14,25},{35,123},{2,10},{36,128},{1,11}};
//        Map<String, Object> res = rentRequest(requestArray,365);
//        System.out.println("个数：" + res.get("size"));
//        System.out.println("请求：" + JSON.toJSONString(res.get("array")));

//        System.out.println(intToString(6));
        Boolean a = null;
        if (a != null && a == true) {
            System.out.println(111);
        }
        System.out.println(222);
    }

    /**
     * 假设你有一个房间要出租1年，然后收到了很多租赁请求，里面包含了开始日期和结束日期。求最多可以满足的请求数
     * 入参类似[(2,10), (14,25), (35, 123)...]，第一个数字代表开始日期（一年中的第几天），第二个数字代表结束日期。
     * 输出结果类似：8 （最多可以满足的请求数），和 [(2,10),(14,25)...] （所有满足条件的请求）
     */
    public static Map<String, Object> rentRequest(int[][] requestArray, int days) {
        Map<String, Object> map = new HashMap<>();
        // 初始化返回值
        int[][] res = new int[requestArray.length][2];
        // 排序 以二维数组起始值排序
        Arrays.sort(requestArray, Comparator.comparingInt(o -> o[0]));
        System.out.println("排完序的array：" + JSON.toJSONString(requestArray));
        int start = 0;
        int end = days;
        int x = 0;
        int y = 0;
        for (int i = 0; i < requestArray.length; i++){
            System.out.println("start:" + start + ", array[0]: " + requestArray[i][0] + ", array[1]: " + requestArray[i][1]);
            if(requestArray[i][0] > start && requestArray[i][1] < days){
                y = x++;
                res[y][0] = requestArray[i][0];
                res[y][1] = requestArray[i][1];
                start = requestArray[i][1];
            }
        }
        // 把 [0,0] 去掉
        int[][] finalRes = new int[y+1][2];
        for (int i = 0; i < res.length; i++){
            if(res[i][0] == 0 && res[i][1] == 0){
              continue;
            }
            finalRes[i][0] =res[i][0];
            finalRes[i][1] =res[i][1];
        }

        map.put("size", y+1);
        map.put("array", finalRes);
        return map;
    }

    /**
     * 找出下面代码的规律并且编写一个函数，转换特定的整数到对应的字符串。
     * 1 => A，2 => B，3 => C，...，26 => Z，27 => AA，28 => AB，29 => AC，...，52 => AZ，53 => BA，...
     * 英文字母与数字的相互转换如： A->1 AA->27 26->Z 28->AB  数字转字母 最后给一串数字 算对应字母加排序
     */
    public static String intToString(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        while (i > 0) {
            // 65 -> A
            stringBuilder.append( (char) ((i % 26) == 0 ? 'Z' : (i % 26) + 'A' - 1));
            i = (i - 1) / 26;
        }
        System.out.println((char) (3 + 'B'));
        return stringBuilder.reverse().toString();
    }

    /**
     * 反转链表
     * 1->2>3>4>5
     * 5>4>3>2>1
     *
     * 迭代
     */
    public static ListNode intToString(ListNode listNode) {
        ListNode cur = listNode;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }

    /**
     * 反转链表
     *
     * 递归
     */
    public static ListNode recursionNode(ListNode listNode) {
      if (listNode == null || listNode.next == null ) {
          return listNode;
      }
        ListNode listNode1 = recursionNode(listNode.next);
        listNode.next.next = listNode;
        listNode.next = null;
        return listNode1;
    }



}
