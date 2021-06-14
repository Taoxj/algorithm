package com.xjt.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 重排链表
 * 
 * @author kevin
 * @date 2021/4/11
 */
public class ReorderList {

    /**
     * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
     * 
     * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * 示例 1:
     *
     * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
     *
     */

    /**
     * 思路：用线性表保存，前后两个指针，一个从头遍历，一个从后往前遍历，
     *
     * 两个复杂度都是O(n)
     * 
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        // 此时i == j，都指向最后一个元素了，所以下个指针为空
        list.get(i).next = null;
    }

    /**
     * 思路2：寻找链表中点 + 链表逆序 + 合并链表
     *
     * 时间：O(n) 空间：O(1)
     */
    public void reorderList2(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    /**
     * 快慢指针找出中间结点
     * 
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 反转链表，主要是反转中间结点右半段用的
     * 
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 合并两个链表
     * 
     * @param l1
     * @param l2
     */
    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
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
