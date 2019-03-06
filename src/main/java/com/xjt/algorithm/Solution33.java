package com.xjt.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * [剑指offer] 面试题33：二叉搜索树的后序遍历序列
 */
public class Solution33 {
    /**
     题目描述：
     输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同
     */

    /**
     * 解题思路：
     * 二叉搜索树：左子树<根<=右子树
     * 后序遍历的数组里，最后一个元素一定是根节点，根据这个元素，把前面的数组分成左右两部分
     * 左侧部分都比该元素小，右侧都比该元素大，再对这两部分的数据做递归判断
     */

    public boolean judgeTree(int[] sequence, int start, int root) {
        if (sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        if (start >= root) {
            return true;
        }
        int i = start;
        while (i < root && sequence[i] < sequence[root]) {
            i++;
        }
        for (int j = i; j < root; j++) {
            if (sequence[j] < sequence[root])
                return false;
        }
        return (judgeTree(sequence, start, i - 1)) && (judgeTree(sequence, i, root - 1));
    }
}
