package me.ihainan

object P160 {
  def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {
    var (p, q) = (headA, headB)
    if (p == null || q == null) null
    else {
      while (p != q) {
        p = if (p == null) headB else p.next
        q = if (q == null) headA else q.next
      }
      p
    }
  }
}