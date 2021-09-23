package me.ihainan

object O25 {
  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    val dummy = new ListNode(0)
    var (p, q, c) = (l1, l2, dummy)
    while (p != null || q != null) {
      if (p == null || (q != null && p.x > q.x)) {
        c.next = q
        q = q.next
      } else {
        c.next = p
        p = p.next
      }
      c = c.next
    }
    dummy.next
  }
}