package me.ihainan

object P725 {

  /** Definition for singly-linked list. class ListNode(_x: Int = 0, _next:
    * ListNode = null) { var next: ListNode = _next var x: Int = _x }
    */
  def getLen(node: ListNode): Int = {
    var len = 0
    var p = node
    while (p != null) {
      p = p.next
      len += 1
    }
    len
  }

  def splitListToParts(head: ListNode, k: Int): Array[ListNode] = {
    val dummy = new ListNode(-1)
    dummy.next = head
    val len = getLen(head)
    val (avg, rst) = (len / k, len % k)
    var (prev, current) = (dummy, head)
    (0 until k).map { i =>
      val start = current
      prev.next = null
      val step = if (i < rst) avg + 1 else avg
      var j = 0
      while (current != null && j < step) {
        if (current != null) {
          prev = current
          current = current.next
        }
        j += 1
      }
      start
    }.toArray
  }
}
