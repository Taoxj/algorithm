package com.xjt.algorithm;

/**
 * 两数相加
 * 
 * @author kevin
 * @date 2021/4/11
 */
public class AddTwoNumbers {

    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 实例：
     *
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     *
     * 输出：[7,0,8]
     * 
     * 解释：342 + 465 = 807.
     */

    /**
     * 思路： 两个链表长度不相等的话，链表短的对应位置置为0，然后两个链表对应位置相加大于10的话，那么这个位置的前一个元素相加就要加1
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        // 进位符
        int carry = 0;
        while (l1 != null || l2 != null) {
            // 对应位置为空，就置位0

            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            // 相加后的结果放到一个新链表中
            cur.next = new ListNode(sum);

            // 继续下一个循环链表对应位置的操作
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            // 如果两个链表全部遍历完毕后，进位值大于0（绝对是1），则在新链表最前方添加节点 1
            // 因为新链表是倒序排列的，所以进位要 放到最后
            if (carry > 0) {
                cur.next = new ListNode(carry);
            }
        }
        return pre.next;
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
