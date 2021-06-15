package me.ihainan

object O52Scala {
  def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {
    var (p, q) = (headA, headB)
    while (p != q) {
      p = if (p == null) headB else p.next
      q = if (q == null) headA else q.next
    }
    p
  }
}