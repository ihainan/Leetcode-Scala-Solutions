package me.ihainan

/** Definition for singly-linked list. class ListNode(var _x: Int = 0) { var
  * next: ListNode = null var x: Int = _x }
  */
object P25 {
  def reverse(head: ListNode): ListNode = {
    var p: ListNode = null
    var q = head
    while (q != null) {
      val next = q.next
      q.next = p
      p = q
      q = next
    }
    p
  }

  def reverseKGroup(head: ListNode, k: Int): ListNode = {
    val dummy = new ListNode(0)
    dummy.next = head
    var p = dummy
    while (p != null) {
      var q = p
      (0 until k).foreach { _ =>
        q = q.next
        if (q == null) return dummy.next
      }

      val last = p.next
      val next = q.next
      q.next = null
      val reversed = reverse(p.next)
      p.next = reversed
      last.next = next
      p = last
    }
    dummy.next
  }
}
