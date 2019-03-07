package com.xjt.algorithm.sort;

/**
 * 经典的topK问题
 */
public class TopK {

    /**
     * 题目要求，从n个数据中找出最大(最小)的m个数
     */

    /**
     * 思路：可以用最小堆
     * 先用最小堆对数据中的前m个数做堆排序，然后把其他的数一一与最小堆中的根节点做比较，
     * 大于根节点就与根节点替换，然后重整最小堆，小于或等于根节点就跳过
     * 因为最小堆的根节点最小，所以这样就能找出最大的m个数了
     */

    public static void main(String[] args) {
        // 模拟数据
        int[] data = {56, 275, 12, 6, 45, 478, 41, 1236, 456, 12, 546, 45};

        MinHeap heap = new MinHeap(data);

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }

//        // 获取前5个值
//        int[] top5 = topK(data, 5);
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println(top5[i]);
//        }

    }

    // 从data数组中获取最大的k个数
    public static int[] topK(int[] data, int k) {
        // 先取K个元素放入一个数组topk中
        int[] topk = new int[k];
        for (int i = 0; i < k; i++) {
            topk[i] = data[i];
        }

        // 转换成最小堆
        MinHeap heap = new MinHeap(topk);

        // 从k开始，遍历data
        for (int i = k; i < data.length; i++) {
            int root = heap.getRoot();

            // 当数据大于堆中最小的数（根节点）时，替换堆中的根节点，再转换成堆
            if (data[i] > root) {
                heap.setRoot(data[i]);
            }
        }

        return topk;
    }


    public static class MinHeap {
        // 堆的数据结构，数组
        private int[] data;

        // 将一个数组传入构造方法，并转换成一个小根堆
        public MinHeap(int[] data) {
            this.data = data;
            buildHeap();
        }

        // 将数组转换成最小堆
        public void buildHeap() {
            // 完全二叉树只有数组下标小于或等于 (data.length) / 2 - 1 的元素有孩子结点，遍历这些结点。
            // *比如上面的图中，数组有10个元素， (data.length) / 2 - 1的值为4，a[4]有孩子结点，但a[5]没有*
            for (int i = (data.length) / 2 - 1; i >= 0; i--) {
                // 对有孩子结点的元素heapify
                heapify(i);
            }
        }

        // 创建调整堆
        public void heapify(int val) {
            int l = left(val);
            int r = right(val);

            // 临时变量，表示当前结点、左结点、右结点中最小的值的结点的下标
            int smallest = val;

            // 存在左结点，且左结点的值小于根结点的值
            if (l < data.length && data[l] < data[val])
                smallest = l;

            // 存在右结点，且右结点的值小于以上比较的较小值
            if (r < data.length && data[r] < data[smallest])
                smallest = r;

            // 左右结点的值都大于根节点，不做任何操作
            if (val == smallest) {
                return;
            }

            // 交换根节点和左右结点中最小的那个值，把根节点的值替换下去
            swap(val, smallest);

            // 由于替换后左右子树会被影响，所以要对受影响的子树再进行heapify
            heapify(smallest);
        }

        // 交换元素位置
        private void swap(int i, int j) {
            int tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
        }

        // 获取右结点的数组下标
        private int right(int i) {
            return (i + 1) << 1;
        }

        // 获取左结点的数组下标
        private int left(int i) {
            return ((i + 1) << 1) - 1;
        }

        // 获取对中的最小的元素，根元素
        public int getRoot() {
            return data[0];
        }

        // 替换根元素，并重新heapify
        public void setRoot(int root) {
            data[0] = root;
            heapify(0);
        }

    }
}
