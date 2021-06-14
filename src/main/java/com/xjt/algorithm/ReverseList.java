package com.xjt.algorithm;

/**
 * 反转链表
 * 
 * @author kevin
 * @date 2021/4/1
 */
public class ReverseList {

    /**
     * 反转一个单链表。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
     *
     */

    // 思路：
    // 1、迭代 在遍历链表时，将当前节点的next 指针改为指向前一个节点。
    // 由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
    // 2、递归
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 迭代，用两个额外的指针来实现，pre：前置节点，curr：当前节点 时间复杂度：O(n)、 空间复杂度：O(1)
     * 
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 递归，时间复杂度：O(n)、 空间复杂度：O(n)
     * 
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
