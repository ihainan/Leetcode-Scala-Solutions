package me.ihainan

object O22 {
  def getKthFromEnd(head: ListNode, k: Int): ListNode = {
    var (p, q) = (head, head)
    (0 until k).foreach { _ => p = p.next }
    while (p != null) {
      p = p.next
      q = q.next
    }
    q
  }
}