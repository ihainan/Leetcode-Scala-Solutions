package me.ihainan

object O52Scala {
  def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {
    var (p, q) = (headA, headB)
    while (p != q) {
      if (p == null) p = headB else p = p.next
      if (q == null) q = headA else q = q.next
    }
    p
  }
}