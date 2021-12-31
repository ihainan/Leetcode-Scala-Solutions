package me.ihainan

object P24 {
  def swapPairs(head: ListNode): ListNode = {
    val dummy = new ListNode(0)
    dummy.next = head
    var p = dummy
    while (p.next != null && p.next.next != null) {
      val n = p.next
      val nn = n.next
      val nnn = nn.next
      n.next = nnn
      p.next = nn
      nn.next = n
      p = n
    }
    dummy.next
  }
}