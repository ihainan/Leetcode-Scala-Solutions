/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null | headB == null) return null;

    
    ListNode p1 = headA;
    ListNode p2 = headB;
    while (p1.next != null) p1 = p1.next;
    while (p2.next != null) p2 = p2.next;
    if (p1 != p2) return null;

    p1 = headA;
    p2 = headB;
    while (p1 != p2) {
      if (p1.next == null) p1 = headB;
      else p1 = p1.next;
      if (p2.next == null) p2 = headA;
      else p2 = p2.next;
    }
    return p1;
  }
}
