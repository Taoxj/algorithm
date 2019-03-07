package com.xjt.algorithm.sort;

/**
 * 选择排序
 */
public class SelectSort {

    /**
     * 基本思想：
     * 选择排序是一种简单直观的排序算法，其基本原理如下：
     * 对于给定的一组记录，经过第一轮比较后得到最小的记录，然后将该记录的位置与第一个记录的位置交换；
     * 接着对不包括第一个记录以外的其他记录进行第二次比较，得到最小记录并与第二个位置记录交换；
     * 重复该过程，知道进行比较的记录只剩下一个为止。
     */


    /**
     * 简单选择排序
     * 时间复杂度：O（n^2）
     *
     * @param data
     */
    public static void selectSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int temp = data[i];
            int flag = i; //将当前下标定义为最小值下标
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < temp) { //a[j] < temp 从小到大排序；a[j] >temp 从大到小排序
                    temp = data[j];
                    flag = j; //如果有小于当前最小值的关键字将此关键字的下标赋值给flag
                }
            }
            if (flag != i) {
                data[flag] = data[i];
                data[i] = temp;
            }
        }

    }
}
