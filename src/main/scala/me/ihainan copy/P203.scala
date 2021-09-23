package me.ihainan

object P203 {
  def removeElements(head: ListNode, `val`: Int): ListNode = {
    val dummy = new ListNode(-1)
    dummy.next = head
    var p = dummy
    while (p.next != null) {
      if (p.next.x == `val`) p.next = p.next.next
      else p = p.next
    }
    dummy.next
  }
}