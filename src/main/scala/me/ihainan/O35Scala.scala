package me.ihainan

object O35Scala {
  /**
    * Definition for a Node.
    * class Node(var _value: Int) {
    *   var value: Int = _value
    *   var next: Node = null
    *   var random: Node = null
    * }
    */

  def copyRandomList(head: Node): Node = {
    val dummy = new Node(-1)
    val map = collection.mutable.Map.empty[Node, Node]
    var p = head
    var q = dummy
    while (p != null) {
      val node = new Node(p.value)
      q.next = node
      q = q.next
      map(p) = q
      p = p.next
    }
    p = head
    q = dummy.next
    while (p != null) {
      q.random = if (p.random == null) null else map(p.random)
      p = p.next
      q = q.next
    }
    dummy.next
  }
}