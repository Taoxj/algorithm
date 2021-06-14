package com.xjt.algorithm;

/**
 * 旋转链表
 * 
 * @author kevin
 * @date 2021/4/16
 */
public class RotateRight {

    /**
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     *
     * 输入：head = [1,2,3,4,5], k = 2
     * 
     * 输出：[4,5,1,2,3]
     */

    /**
     * 根据题意，我们可以假设链表是：1 -> 2 -> 3 -> 4 -> 5-> 1−>2−>3−>4−>5，移动位是 k，我们分析如下：
     *
     * k<5 的情况：实际移动的位数，就是 k 本身。
     *
     * k>5 的情况：
     *
     * k 是 5 的整数倍：链表不会发生位置变化。
     * 
     * k 不是 5 的整数倍：实际移动位数是 k%5 的值。
     *
     * 知道了上述的分析，我们很容易就能理清思路，流程如下：
     *
     * 1、计算链表的长度
     *
     * 2、链表最后一位值的 next 指向原链表首位数字，形成闭环，例如原来是1 -> 2 -> 3 -> 4 -> 5： 那么就会变成 1 -> 2 -> 3 -> 4 -> 5-> 1−>2−>3−>4−>5.....
     *
     * 3、创建一个变量，接收从 k 处截断后的链表，假设 k=2，我们就会从 3 这里处截断，然后 3 的 next 指向 null 即可，所以该变量的值是 4 -> 5 -> 1 -> 2 -> 3 -> null
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        // 找一个结点来做遍历
        ListNode itr = head;

        // 先把结点遍历到最后一个结点，并计算出链表的长度
        while (itr.next != null) {
            itr = itr.next;
            n++;
        }

        // itr要向前移动的步数为n - k % n
        int add = n - k % n;
        // k为n的整数倍，说明链表保持不变
        if (add == n) {
            return head;
        }
        // 最后一个结点指向头结点，形成一个环
        itr.next = head;
        // 移动对应的步数
        while (add-- > 0) {
            itr = itr.next;
        }
        // 按照上面的例子，假设k=2，那么这个时候的itr就等于 结点3
        // 让itr的后结点4做为头，然后itr指向null，因为之前的结点已经成环了，所以新的链表就会是这样4 -> 5 -> 1 -> 2 -> 3 -> null
        ListNode next = itr.next;
        itr.next = null;
        return next;
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
