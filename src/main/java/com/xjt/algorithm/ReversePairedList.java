package com.xjt.algorithm;

public class ReversePairedList {

    /**
     * 单链表两两反转
     *
     *      已知一个链表：a->b->c->d->e
     * 每两个元素进行反转：b->a->d->c->e
     */

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode reversePairedList(ListNode head){
        if(head == null) return null;

        ListNode a = head;          //当前节点A
        ListNode b = head.next;     //下个节点B
        ListNode temp;              //下下个节点C
        ListNode previous = null;   //上一组的尾指针，在下一组反转后需要改变
        ListNode newHead = b == null ? a : b;

        while(b != null){
            temp = b.next;  // 记录C节点
            b.next = a;     // a->b 反向
            a.next = temp;
            if(previous != null){
                previous.next = b;
            }

            if(temp == null){
                break;
            }
            previous = a;
            a = temp;       //移动到下一组
            b = temp.next;
        }
        return newHead;
    }
}
