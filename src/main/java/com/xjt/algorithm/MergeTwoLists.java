package com.xjt.algorithm;

/**
 * 合并两个有序链表
 * 
 * @author kevin
 * @date 2021/4/4
 */
public class MergeTwoLists {

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * 实例：
     *
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 
     * 输出：[1,1,2,3,4,4]
     */

    /**
     * 我们可以如下递归地定义两个链表里的 merge 操作（忽略边界情况，比如空链表等）：
     *
     * list1[0]+merge(list1[1:],list2) list1[0]<list2[0]
     * 
     * list2[0]+merge(list1,list2[1:]) otherwise ​
     *
     * 也就是说，两个链表头部值较小的一个节点与剩下元素的 merge 操作结果合并
     *
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
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
