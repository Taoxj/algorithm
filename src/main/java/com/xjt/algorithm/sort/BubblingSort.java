package com.xjt.algorithm.sort;

/**
 * 冒泡排序
 */
public class BubblingSort {
    public static void main(String[] args) {
        int[] arr = {56, 275, 12, 6, 45, 478, 41, 1236, 456, 12, 546, 45};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void bubbleSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {//注意第二重循环的条件
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
}
