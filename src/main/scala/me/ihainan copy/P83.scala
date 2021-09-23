package me.ihainan

object P83 {
  def deleteDuplicates(head: ListNode): ListNode = {
    val dummy = new ListNode(0, head)
    var p = head
    while (p != null && p.next != null) {
      if (p.next.x == p.x) {
        p.next = p.next.next
      } else p = p.next
    }
    dummy.next
  }
}