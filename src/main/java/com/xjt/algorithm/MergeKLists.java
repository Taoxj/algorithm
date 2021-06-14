package com.xjt.algorithm;

/**
 *
 * 合并 K 个排序链表
 * 
 * @author kevin
 * @date 2021/5/16
 */
public class MergeKLists {

    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     *
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表
     *
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 
     * 输出：[1,1,2,3,4,4,5,6]
     */

    /**
     * 思路：分而治之
     *
     * 链表两两合并
     *
     * 时间复杂度：O(n*log(k))O(n∗log(k))，n 是所有链表中元素的总和，k 是链表个数。
     */

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        return merge(lists, 0, lists.length - 1);
    }

    /**
     * 合并，用递归实现
     * 
     * @param lists
     * @param left
     * @param right
     * @return
     */
    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right)
            return lists[left];
        // 找出两个索引中间的坐标
        int mid = left + (right - left) / 2;
        // 递归排序好左右两边的链表
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        // 最后来一遍总的排序
        return mergeTwoLists(l1, l2);
    }

    /**
     * 合并两个排序链表
     * 
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
