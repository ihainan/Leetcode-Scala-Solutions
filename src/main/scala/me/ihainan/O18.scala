package me.ihainan

object O18 {
  def deleteNode(head: ListNode, value: Int): ListNode = {
    val dummy = new ListNode(-1)
    dummy.next = head
    var p = dummy
    while (p.next != null) {
      if (p.next.x == value) {
        p.next = p.next.next
      } else p = p.next
    }
    dummy.next
  }
}