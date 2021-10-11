package com.xjt.algorithm;

import java.util.PriorityQueue;

/**
 * 找出n个降序链表中的第k大的值
 * 
 * @author kevin
 * @date 2021/6/14
 */
public class KthNumberInDesOrderList {

    /**
     * 给定n个链表，每个链表中的元素都分别是降序排列的，找出n个链表所包含的所有数中的第k大的值。
     *
     * 示例：给定3个降序链表，找出第4大的值。
     * 
     * 9 -> 6 -> 2
     *
     * 10 -> 3 -> 2 -> 1
     *
     * 5 -> 1
     *
     * 要找的第4大的值应该为5。
     */

    /**
     * 思路：利用大跟堆的实现，优先队列存储链表结点，同时需要自定义比较方法。将每个链表的头结点都入堆，结点元素最大的结点会位于堆顶。
     *
     * 弹出该结点，并且若该结点还有下一个结点，也将其入堆。这样，弹出的第k个结点元素，即为所需要的答案。
     */

    public int kthNumber(ListNode head, int k) {
        if (head == null) {
            return 0;
        }
        // 定义一个大根堆，大的排在前面
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> {
            return o2.val - o1.val;
        });
        queue.add(head);
        if (head.next != null) {
            queue.add(head.next);
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();

        }
        return 0;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
