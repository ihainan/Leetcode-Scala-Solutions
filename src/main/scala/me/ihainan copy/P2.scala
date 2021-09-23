package me.ihainan

object P2 {
  /**
    * Definition for singly-linked list.
    * class ListNode(_x: Int = 0, _next: ListNode = null) {
    *   var next: ListNode = _next
    *   var x: Int = _x
    * }
    */
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    val dummy = new ListNode(-1)
    var (p, q, curr) = (l1, l2, dummy)
    var carry = 0
    while (p != null || q != null) {
      val v1 = if (p == null) 0 else p.x
      val v2 = if (q == null) 0 else q.x
      val sum = v1 + v2 + carry
      carry = sum / 10
      curr.next = new ListNode(sum % 10)
      if (p != null) p = p.next
      if (q != null) q = q.next
      curr = curr.next
    }
    if (carry != 0) curr.next = new ListNode(carry)
    dummy.next
  }
}