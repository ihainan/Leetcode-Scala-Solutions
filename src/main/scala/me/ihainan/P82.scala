package me.ihainan

object P82 {
  def deleteDuplicates(head: ListNode): ListNode = {
    val dummy = new ListNode(0, null)
    var (p, q) = (dummy, head)
    while (q != null) {
      if (q.next == null || q.next.x != q.x) {
        p.next = q
        p = q
        q = q.next
      } else {
        while (q.next != null && q.next.x == q.x) q = q.next
        q = q.next
        p.next = null
      }
    }
    dummy.next
  }
}
