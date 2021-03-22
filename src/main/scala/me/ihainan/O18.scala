package me.ihainan

object O18 {
  def deleteNode(head: ListNode, `val`: Int): ListNode = {
    val dummy = new ListNode(-1)
    dummy.next = head
    var pre: ListNode = dummy
    var cur = head
    while (cur != null) {
      val next = cur.next
      if (cur.x == `val`) pre.next = next
      else pre = cur
      cur = next
    }
    dummy.next
  }
}