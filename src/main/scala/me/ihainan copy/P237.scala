package me.ihainan

object P237 {
  /**
    * Definition for singly-linked list.
    * class ListNode(var _x: Int = 0) {
    *   var next: ListNode = null
    *   var x: Int = _x
    * }
    */

  def deleteNode(node: ListNode): Unit = {
    var p = node
    while (p.next != null) {
      p.x = p.next.x
      if (p.next.next == null) p.next = null
      else p = p.next
    }
  }
}