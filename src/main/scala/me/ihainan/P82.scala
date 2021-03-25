package me.ihainan

object P82 {
  def deleteDuplicates(head: ListNode): ListNode = {
    val dummy = new ListNode(0, head)
    var p = dummy
    while (p != null) {
      while (p.next != null && p.next.next != null && p.next.x == p.next.next.x) {
        val x = p.next.x
        while (p.next != null && p.next.x == x) p.next = p.next.next
      }
      p = p.next
    }
    dummy.next
  }
}