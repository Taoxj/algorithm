package com.xjt.algorithm;

/**
 * 删除排序链表中的重复元素
 * 
 * @author kevin
 * @date 2021/4/4
 */
public class DeleteDuplicates {

    /**
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
     *
     * 输入：head = [1,1,2]
     * 
     * 输出：[1,2]
     */

    /**
     * 思路 标签：链表
     *
     * 指定 cur 指针指向头部 head
     *
     * 当 cur 和 cur.next 的存在为循环结束条件，当二者有一个不存在时说明链表没有去重复的必要了
     *
     * 当 cur.val 和 cur.next.val 相等时说明需要去重，则将 cur 的下一个指针指向下一个的下一个，这样就能达到去重复的效果
     *
     * 如果不相等则 cur 移动到下一个位置继续循环
     *
     * 时间复杂度：O(n)
     *
     *
     * 作者：guanpengchn
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/solution/hua-jie-suan-fa-83-shan-chu-pai-xu-lian-biao-zhong/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
