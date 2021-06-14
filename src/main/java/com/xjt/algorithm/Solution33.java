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

    /**
     * 比较正规的写法
     * @param sequence
     * @return
     */
    public boolean verifySquenceOfBST(int sequence[]){
        if(sequence == null){
            return false;
        }
        return verifySquenceOfBST1(sequence, 0, sequence.length - 1);
    }

    private boolean verifySquenceOfBST1(int[] sequence, int start, int end) {
        if(start >= end){
            return true;
        }
        int root = sequence[end]; //后序遍历的最后一个结点为根结点

        //在二叉搜索树中左子树的结点小于根结点
        int i = 0;
        for(; i < end; ++i){
            if(sequence[i] > root){
                break;
            }
        }

        //在二叉搜索树中右子树的结点大于根结点
        int j = i;
        for(; j < end; ++j){
            if(sequence[j] < root){
                return false;
            }
        }
        //判断左子树是不是二叉树
        boolean left = true;
        if(i > start){
            left = verifySquenceOfBST1(sequence, start, i-1);
        }
        //判断右子树是不是二叉树
        boolean right = true;
        if(i < end){
            right = verifySquenceOfBST1(sequence, i, end -1);
        }
        return (left && right);
    }

}
