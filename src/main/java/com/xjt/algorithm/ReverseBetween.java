package com.xjt.algorithm;

/**
 * 反转链表 II
 * 
 * @author kevin
 * @date 2021/4/3
 */
public class ReverseBetween {

    /**
     * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
     *
     * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     *
     * 实例：
     *
     * 输入：head = [1,2,3,4,5], left = 2, right = 4 输出：[1,4,3,2,5]
     */

    /**
     * 思路：
     *
     * 1、我们定义两个指针，分别称之为 g(guard 守卫) 和 p(point)。
     *
     * 我们首先根据方法的参数 m 确定 g 和 p 的位置。将 g 移动到第一个要反转的节点的前面，将 p 移动到第一个要反转的节点的位置上。
     *
     * 我们以 m=2，n=4为例。
     *
     * 2、将 p 后面的元素删除，然后添加到 g 的后面。也即头插法。
     * 
     * 3、根据 m 和 n 重复步骤（2）
     *
     * 4、返回dummyHead.next
     *
     */

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return null;
        // 初始化一个dummyHead结点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        // 初始化两个指针
        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        // 将指针移到相应的位置
        for (int step = 0; step < m - 1; step++) {
            g = g.next;
            p = p.next;
        }

        // 头插法插入节点
        for (int i = 0; i < n - m; i++) {
            ListNode removed = p.next;
            p.next = p.next.next;

            removed.next = g.next;
            g.next = removed;
        }
        return dummyHead.next;
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
