package com.xjt.algorithm;

import java.util.Stack;

/**
 * [剑指offer] 面试题09：用两个栈实现队列
 *
 * @author Tao
 * @since 2019/4/6 20:26
 */
public class Solution09Test {

    /**
     * 题目描述：
     * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     */

    /**
     * 思路：
     * 两个栈 stack1 和 stack2:
     * push 动作都在 stack1 中进行，
     * pop 动作在 stack2 中进行。当 stack2 不为空时，直接 pop，当 stack2 为空时，先把 stack1 中的元素 pop 出来，push 到 stack2 中，再从 stack2 中 pop 元素。
     */

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int val) {
        stack1.push(val);
    }

    public int pop() {
        if (stack1.isEmpty() && stack2.isEmpty())
            throw new RuntimeException("Queue is empty!");
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
