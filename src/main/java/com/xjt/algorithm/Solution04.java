package com.xjt.algorithm;

/**
 * [剑指offer] 面试题04：二维数组中的查找
 */
public class Solution04 {

    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
     */

    /**
     * 解题思路：
     * 二维数组是有序的，从右上角来看，向左数字递减，向下数字递增。
     * 因此从右上角开始查找，
     * <p>
     * 当要查找数字比右上角数字大时，下移；
     * 当要查找数字比右上角数字小时，左移；
     * 如果出了边界，则说明二维数组中不存在该整数。
     */

    public boolean findNumInArray(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        int m = array[0].length - 1;        //右上角数组的下标
        int n = 0;
        int temp = array[n][m];
        while (target != temp) {
            if (m > 0 && n < array.length - 1) {
                if (target > temp) {
                    n++;
                } else if (target < temp) {
                    m = m - 1;
                }
                temp = array[n][m];
            } else {
                return false;
            }
        }
        return true;
    }
}
