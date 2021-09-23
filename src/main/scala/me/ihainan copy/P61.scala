package me.ihainan

object P61 {
  def rotateRight(head: ListNode, k: Int): ListNode = {
    if (head == null) null
    else {
      var len = 1
      var tail = head
      while (tail.next != null) {
        tail = tail.next
        len += 1
      }
      tail.next = head
      var newTail = head
      (0 until len - k % len - 1).foreach { _ => newTail = newTail.next }
      val newHead = newTail.next
      newTail.next = null
      newHead
    }
  }
}