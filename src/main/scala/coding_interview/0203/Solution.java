/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public void deleteNode(ListNode node) {
    ListNode p = node;
    while (p.next != null) {
      p.val = p.next.val;
      if (p.next.next == null) p.next = null;
      else p = p.next;
    }
  }
}
