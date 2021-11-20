package me.ihainan

object P21 {

  /** Definition for singly-linked list. class ListNode(_x: Int = 0, _next:
    * ListNode = null) { var next: ListNode = _next var x: Int = _x }
    */
  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    val dummy = new ListNode(0, null)
    var prev = dummy
    var (p, q) = (l1, l2)
    while (p != null && q != null) {
      if (p.x <= q.x) {
        prev.next = p
        p = p.next
      } else {
        prev.next = q
        q = q.next
      }
      prev = prev.next
    }
    if (p == null) prev.next = q else prev.next = p
    dummy.next
  }
}
