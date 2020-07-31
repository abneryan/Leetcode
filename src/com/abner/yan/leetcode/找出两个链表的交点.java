package com.abner.yan.leetcode;

import java.util.List;

/**
 * @Auther: yanguoqing
 * @Date: 2020/5/13 13:47
 * @Description:
 */
public class 找出两个链表的交点 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? l2 : l1.next;
            l2 = (l2 == null) ? l1 : l2.next;
        }
        return l1;

    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
