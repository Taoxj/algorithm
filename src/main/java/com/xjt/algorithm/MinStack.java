package com.xjt.algorithm;

import java.util.Stack;

/**
 * 设计最小栈
 * 
 * @author kevin
 * @date 2021/4/2
 */
public class MinStack {
    /**
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     *
     * push(x) —— 将元素 x 推入栈中。 pop() —— 删除栈顶的元素。 top() —— 获取栈顶元素。 getMin() —— 检索栈中的最小元素。
     *
     */

    /**
     * 数据栈，栈里的元素是正常排列的
     */
    private Stack<Integer> data;

    /**
     * 辅助栈，栈顶的元素永远是最小的，但是个数必须和数据栈保持一致，时间复杂度：O(1)，空间复杂度：O(n)
     */
    private Stack<Integer> helper;

    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    /**
     * 数据栈和辅助栈在任何时候都同步
     * 
     * @param x
     */
    public void push(int x) {
        data.push(x);
        if (helper.empty() || helper.peek() >= x) {
            helper.push(x);
        } else {
            helper.push(helper.peek());
        }
    }

    public void pop() {
        // 两个栈都得 pop
        if (!data.isEmpty()) {
            helper.pop();
            data.pop();
        }
    }

    public int top() {
        if (!data.isEmpty()) {
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public int getMin() {
        if (!helper.empty()) {
            helper.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
}
