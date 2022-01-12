package me.ihainan

object P430 {

  /** Definition for a Node. class Node(var _value: Int) { var value: Int =
    * _value var prev: Node = null var next: Node = null var child: Node = null
    * }
    */
  class Node(var _value: Int) {
    var value: Int = _value
    var prev: Node = _
    var next: Node = _
    var child: Node = _
  }

  def flatten(head: Node): Node = {
    var prev: Node = null

    def solve(head: Node): Unit = {
      var p = head
      while (p != null) {
        val next = p.next
        if (prev != null) prev.next = p
        p.prev = prev
        prev = p
        solve(p.child)
        p.child = null
        p = next
      }
    }

    solve(head)
    head
  }
}
