package com.xjt.algorithm;

/**
 * K 个一组翻转链表
 * 
 * @author kevin
 * @date 2021/4/2
 */
public class ReverseKGroup {

    /**
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     *
     * k 是一个正整数，它的值小于或等于链表的长度。
     *
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     * 输入：head = [1,2,3,4,5], k = 2
     * 
     * 输出：[2,1,4,3,5]
     */

    /**
     * 步骤求解：
     *
     * 1、链表分区为已翻转部分+待翻转部分+未翻转部分
     *
     * 2、每次翻转前，要确定翻转链表的范围，这个必须通过 k 此循环来确定
     *
     * 3、需记录翻转链表前驱和后继，方便翻转完成后把已翻转部分和未翻转部分连接起来
     *
     * 4、初始需要两个变量 pre 和 end，pre 代表待翻转链表的前驱，end 代表待翻转链表的末尾
     *
     * 5、经过k此循环，end 到达末尾，记录待翻转链表的后继 next = end.next
     *
     * 6、翻转链表，然后将三部分链表连接起来，然后重置 pre 和 end 指针，然后进入下一次循环
     *
     * 7、特殊情况，当翻转部分长度不足 k 时，在定位 end 完成后，end==null，已经到达末尾，说明题目已完成，直接返回即可
     *
     * 时间复杂度为 O(n*K) 最好的情况为 O(n) 最差的情况未 O(n^2) 空间复杂度为 O(1)除了几个必须的节点指针外，我们并没有占用其他空间
     *
     * 思路链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
     */

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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            // 确定前驱点和翻转链表的后节点
            ListNode start = pre.next;
            ListNode next = end.next;

            end.next = null;
            pre.next = reverse(start);

            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
