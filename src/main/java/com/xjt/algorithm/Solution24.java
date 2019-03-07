package com.xjt.algorithm;

/**
 * [剑指offer] 面试题24：反转链表
 */
public class Solution24 {

    /**
     * 解题思路
     * 设置三个指针，head为当前节点，pre为当前节点的前一个节点，next为当前节点的下一个节点，
     * 需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2的过程中，
     * 用pre让节点反转所指方向，next节点保存next1节点防止链表断开
     */

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null){
            // 先用next保留后节点
            next = head.next;
            head.next = pre;
            // 下面这两步是把pre和head节点往后推移，继续下个循环
            pre = head;
            head = next;
        }
        return pre;
    }
}
