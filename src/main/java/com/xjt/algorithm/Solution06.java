package com.xjt.algorithm;

import java.util.ArrayList;
import java.util.Stack;

/**
 * [剑指offer] 面试题06：从尾到头打印链表
 */
public class Solution06 {

    /**
     * 题目描述：
     * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
     */

    /**
     * 解题思路：
     * 一种是利用递归的方式
     * 另外一种方法是利用三个指针把链表反转，关键是 r 指针保存断开的节点。
     */

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {

        Stack<Integer> stack = new Stack<Integer>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        while (!stack.empty()) {
            res.add(stack.pop());
        }
        return res;
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode == null)
            return new ArrayList<Integer>();
        ListNode head = listNode;
        ListNode cur = listNode.next;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = head;
            head = cur;
            cur = temp;
        }
        //此时listNode的next还指向第二个node，所以要让listNode.next=null,防止循环
        listNode.next = null;
        ArrayList<Integer> res = new ArrayList<Integer>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        return res;
    }
}
