/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) return null;
    ListNode p1 = head;
    ListNode p2 = head.next;
    while (p2 != null && p2.next != null && p1 != p2) {
      p1 = p1.next;
      p2 = p2.next.next;
    }

    if (p2 == null || p2.next == null) return null;

    p1 = head;
    p2 = p2.next;
    while (p1 != p2) {
      p1 = p1.next;
      p2 = p2.next;
    }

    return p1;
  }
}
