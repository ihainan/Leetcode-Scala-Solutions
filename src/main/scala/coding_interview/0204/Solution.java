/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
  def partition(head: ListNode, x: Int): ListNode = {
    val h1 = new ListNode(-1)
    val h2 = new ListNode(-1)
    var (p, q, c) = (h1, h2, head)
    while (c != null) {
      if (c.x < x) {
        p.next = c
        p = p.next
      } else {
        q.next = c
        q = q.next
      }
      c = c.next
    }
    q.next = null // don't forget to set q's next!
    p.next = h2.next
    h1.next
  }
}
