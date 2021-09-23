package me.ihainan

/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object R0205 {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var carry = 0
    val dummy = new ListNode(-1)
    var (p, q, c) = (l1, l2, dummy)
    while (p != null || q != null || carry != 0) {
      val v1 = if (p == null) 0 else p.x
      val v2 = if (q == null) 0 else q.x
      val sum = v1 + v2 + carry
      carry = sum / 10
      c.next = new ListNode(sum % 10)
      if (p != null) p = p.next
      if (q != null) q = q.next
      c = c.next
    } 
    dummy.next
  }
}
