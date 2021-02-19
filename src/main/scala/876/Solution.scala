/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
  def middleNode(head: ListNode): ListNode = {
    var (p, q) = (head, head)
    while (q != null && q.next != null) {
      p = p.next
      q = q.next.next
    }
    p
  }
}
