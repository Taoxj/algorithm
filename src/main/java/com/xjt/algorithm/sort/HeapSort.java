package com.xjt.algorithm.sort;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {56, 275, 12, 6, 45, 478, 41, 1236, 456, 12, 546, 45};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     *  * 构建大顶堆
     * <p>
     *  
     */
    public static void adjustHeap(int[] data, int i, int len) {
        int temp = data[i];

        int lchild = 2 * i + 1;

        while (lchild < len) {
            int rchild = lchild + 1;
            // 沿关键字较大的孩子结点向下筛选
            if (rchild < len && data[lchild] < data[rchild]) {
                ++lchild; // j为关键字中较大记录的下标
            }
            if (temp >= data[lchild]) {
                break;
            }
            data[i] = data[lchild];

            i = lchild;
            lchild = 2 * lchild + 1;

        }
        data[i] = temp;
    }

    /**
     *  * 堆排序
     * <p>
     *  * 时间复杂度：O（n^2）
     * <p>
     *  *@param data
     * <p>
     *  
     */
    public static void heapSort(int[] data) {
        int i;
        for (i = data.length / 2 - 1; i >= 0; i--) { // 构建一个大顶堆
            adjustHeap(data, i, data.length - 1);
        }
        for (i = data.length - 1; i >= 0; i--) { // 将堆顶记录和当前未经排序子序列的最后一个记录交换

            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            adjustHeap(data, 0, i); // 将a中前i-1个记录重新调整为大顶堆
        }

    }
}
