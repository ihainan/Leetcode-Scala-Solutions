package me.ihainan

object O22Solution2 {
  /**
    * Definition for singly-linked list.
    * class ListNode(var _x: Int = 0) {
    *   var next: ListNode = null
    *   var x: Int = _x
    * }
    */
  def getKthFromEnd(head: ListNode, k: Int): ListNode = {
    var p = head
    var len = 0
    while (p != null) {
      len += 1
      p = p.next
    }
    p = head
    (0 until len - k).foreach { _ => p = p.next }
    p
  }
}