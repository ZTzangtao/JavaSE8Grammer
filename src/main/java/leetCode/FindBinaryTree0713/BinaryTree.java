package leetCode.FindBinaryTree0713;

import java.util.ArrayList;
import java.util.List;

/**
 * 寻找二叉树
 *
 * @author zangtao
 * @create 2019 - 07 -13 17:34
 */
public class BinaryTree {


    public static List<Integer> pathInZigZagTree(int label) {
        List<Integer> resultList = new ArrayList<>();
        //label 大于0
        if (label < 1) {
            return null;
        }
        //label 等于1
        if (label == 1) {
            resultList.add(1);
            return resultList;
        }
        //1、确定该数字所在二叉树的层级数
        int numLevels;
        for (int i = 1; i < label; i++) {
            if (Math.pow(2, i) - 1 >= label) {
                numLevels = i;
                break;
            }
        }
        //2、


        return resultList;


    }

    public static void main(String[] args) {
        List<Integer> list = pathInZigZagTree(68);
        list.forEach(System.out::println);
    }


}
