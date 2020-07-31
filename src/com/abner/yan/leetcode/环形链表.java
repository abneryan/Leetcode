package com.abner.yan.leetcode;

/**
 * @Auther: yanguoqing
 * @Date: 2020/5/12 00:11
 * @Description:
 */
public class 环形链表 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast.equals(slow)) {
                return true;
            }
        }
        return false;

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
