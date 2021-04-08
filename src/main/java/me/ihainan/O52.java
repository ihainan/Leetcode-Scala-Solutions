package me.ihainan;

import java.util.Map;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class O52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        while (p != q) {
            if (p == null) p = headB;
            else p = p.next;
            if (q == null) q = headA;
            else q = q.next;
        }
        return p;
    }
}