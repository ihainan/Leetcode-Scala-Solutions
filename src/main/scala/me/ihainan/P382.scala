package me.ihainan

object P382 {

  /** Definition for singly-linked list.
    * class ListNode(_x: Int = 0, _next: ListNode = null) {
    *   var next: ListNode = _next
    *   var x: Int = _x
    * }
    */
  class Solution(_head: ListNode) {
    var p = _head
    val nodes = collection.mutable.ArrayBuffer.empty[ListNode]
    while (p != null) {
      nodes += p
      p = p.next
    }
    val random = new util.Random()

    def getRandom(): Int = {
      val index = random.nextInt(nodes.length)
      nodes(index).x
    }

  }

  /** Your Solution object will be instantiated and called as such:
    * var obj = new Solution(head)
    * var param_1 = obj.getRandom()
    */
}
