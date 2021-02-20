package me.ihainan;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class R0203 {
    public void deleteNode(ListNode node) {
        ListNode p = node;
        while (p.next != null) {
            p.x = p.next.x;
            if (p.next.next == null) p.next = null;
            else p = p.next;
        }
    }
}
