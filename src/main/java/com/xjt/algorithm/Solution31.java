package com.xjt.algorithm;

import java.util.Stack;

/**
 * [剑指offer] 面试题31：栈的压入、弹出序列
 */
public class Solution31 {
    /**
     * 题目描述：
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
     * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
     * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
     * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
     */

    /**
     * 解题思路：借用一个辅助栈
     * 将原数列依次压栈，把栈顶元素与所给出栈队列相比，如果相同则出栈，
     * 如果不同则继续压栈，直到原数列中所有数字压栈完毕。
     * 最后，检测栈中是否为空，若空，说明出栈队列可由原数列进行栈操作得到。
     */
    public boolean isPopOrder(int[] arrA, int[] arrB) {
        if (arrA.length != arrB.length || arrA.length == 0 || arrB.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;
        for (int i = 0; i < arrA.length; i++) {
            stack.push(arrA[i]);
            while (!stack.empty() && stack.peek() == arrB[index]){
                stack.pop();
                index++;
            }
        }
        return stack.empty();
    }
}
