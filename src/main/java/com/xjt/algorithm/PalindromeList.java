package com.xjt.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 * 
 * @author kevin
 * @date 2021/4/2
 */
public class PalindromeList {

    /**
     * 题目描述：请判断一个链表是否为回文链表。 例子：输入: 1->2 输出: false ； 输入: 1->2->2->1 输出: true
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

    /**
     * 思路： 使用双指针法来检查是否为回文。我们在起点放置一个指针，在结尾放置一个指针，每一次迭代判断两个指针指向的元素是否相同，若不同，返回 false；相同则将两个指针向内移动，并继续判断，直到两个指针相遇。
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        List<Integer> list = new ArrayList<Integer>();

        // 将链表的值复制到数组中
        ListNode currNode = head;
        while (currNode != null) {
            list.add(currNode.val);
            currNode = currNode.next;
        }

        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
