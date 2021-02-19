/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
  def kthToLast(head: ListNode, k: Int): Int = {
    var (p, q) = (head, head)
    (0 until k).foreach { _ => q = q.next }
    while (q != null) {
      p = p.next
      q = q.next
    }
    p.x
  }
}
