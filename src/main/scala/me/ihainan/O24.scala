package me.ihainan

object O24 {
  def reverseList(head: ListNode): ListNode = {
    var prev: ListNode = null
    var current = head
    while (current != null) {
      val next = current.next
      current.next = prev
      prev = current
      current = next
    }
    prev
  }
}