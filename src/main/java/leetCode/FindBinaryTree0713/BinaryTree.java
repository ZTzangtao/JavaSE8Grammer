package leetCode.FindBinaryTree0713;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        //初始化层级 初始为2级
        int numLevels = 2;
        //1、确定该数字所在二叉树的层级数
        for (int i = 1; i <= label; i++) {
            if (Math.pow(2, i) - 1 >= label) {
                numLevels = i;
                break;
            }
        }
        System.out.println("确定层级数numLevels:" + numLevels);

        //初始化上级索引
        int subIndex = 0;
        //该层级总共的个数
        int totalNums = (int) Math.pow(2, Double.valueOf(String.valueOf(numLevels - 1)));
        //该层级的最大值
        int NumLevelMax = (int) Math.pow(2, numLevels) - 1;
        //初始化存放每层所有数的数组
        int[] arrayMax = new int[totalNums];
        int o = 0;
        for (int i = NumLevelMax; i > (NumLevelMax - totalNums); i--) {
            arrayMax[o] = i;
            o++;
        }

        if (numLevels % 2 != 0) {
            Arrays.sort(arrayMax);
        }
        //数组下标从0开始
        if (numLevels % 2 != 0) {
            subIndex = ((label - (totalNums - 1)) / 2) + ((label - (totalNums - 1)) % 2) - 1;
        } else {
            subIndex = (totalNums - 1) / 2 - (((label - (totalNums - 1)) / 2) + ((label - (totalNums - 1)) % 2) - 1);
        }
//        subIndex = ((label - (totalNums - 1)) / 2) + ((label - (totalNums - 1)) % 2) - 1;
        resultList.add(label);

        numLevels = numLevels - 1;

        while (numLevels != 1) {
            //2、将这一层所有的数排列
            //这一层所有的个数
            totalNums = (int) Math.pow(2, Double.valueOf(String.valueOf(numLevels - 1)));
            System.out.println("这一层所有的个数totalNums:" + totalNums);
            //这一层的最大数
            NumLevelMax = (int) Math.pow(2, numLevels) - 1;
            System.out.println("这一层的最大数NumLevelMax:" + NumLevelMax);
            //将这一层的所有数存起来
            arrayMax = new int[totalNums];
            int j = 0;
            //按逆序来存储
            for (int i = NumLevelMax; i > (NumLevelMax - totalNums); i--) {
                arrayMax[j] = i;
                j++;
            }

            //如果层级数为奇数，这边需要按正序排个序
            if (numLevels % 2 != 0) {
                Arrays.sort(arrayMax);
            }

            //将目标值替换
            label = arrayMax[subIndex];
            //上一组
            if (numLevels % 2 != 0) {
                subIndex = ((label - (totalNums - 1)) / 2) + ((label - (totalNums - 1)) % 2) - 1;
            } else {
                subIndex = (totalNums - 1) / 2 - (((label - (totalNums - 1)) / 2) + ((label - (totalNums - 1)) % 2) - 1);
            }
//            subIndex = ((label - (totalNums - 1)) / 2) + ((label - (totalNums - 1)) % 2) - 1;
            System.out.println("该数字在上一层的第" + subIndex + "位");

            //将这个数添加到结果集
            resultList.add(label);
            --numLevels;

            //循环到第二级

        }
        resultList.add(1);

        Collections.sort(resultList);

        return resultList;

    }

    public static void main(String[] args) {
        List<Integer> list = pathInZigZagTree(14);

        list.forEach(System.out::println);


    }

}
//本级索引
//    int index = 0;

//            for(int i = 1; i < totalNums; i++){
//                System.out.println("数组["+i + "]:" + arrayMax[i]);
//                if (arrayMax[i] == label ){
//                    System.out.println("该值在这一层的索引为：" + i);
//                   //这一组的索引
//                    index = i;
//                }
//            }