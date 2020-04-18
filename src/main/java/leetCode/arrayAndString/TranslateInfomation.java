package leetCode.arrayAndString;

import java.util.*;

/**
 * @author zangtao
 * @date 2020/4/18 15:36
 */
public class TranslateInfomation {
    /**
     * 2 <= n <= 10
     * 1 <= k <= 5
     * 1 <= relation.length <= 90, 且 relation[i].length == 2
     * 0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i][1]
     *
     * @param n
     * @param relation
     * @param k
     * @return
     */
    public static int numWays(int n, int[][] relation, int k) {
        int q = n - 1;

        List<Map<Integer,Integer>> list = new ArrayList<>();
        Map<Integer,Integer> map ;
        //遍历二维数组
        for(int i = 0; i< relation.length; i++){
            map = new HashMap<>(2);
            for(int j =0; j < relation[i].length; j++){
                if (j == 0){
                    map.put(relation[i][j],null);
                }else{
                    map.put(relation[i][j-1],relation[i][j]);
                }
            }
            list.add(map);
        }
        for(Map<Integer,Integer> keyMap : list){
            Iterator<Map.Entry<Integer,Integer>> iterator = keyMap.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<Integer,Integer> entry = iterator.next();
                System.out.println(entry.getKey() + ":"+ entry.getValue());
            }
        }




        //返回满足k轮的方案数
        return 0;


    }

    public static void main(String[] args) {
        int[][] arr = {{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}};
        System.out.println(TranslateInfomation.numWays(5,arr,3));
    }

}
