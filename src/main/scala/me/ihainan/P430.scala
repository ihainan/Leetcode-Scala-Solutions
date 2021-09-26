package me.ihainan

object P430 {
/**
 * Definition for a Node.
 * class Node(var _value: Int) {
 *   var value: Int = _value
 *   var prev: Node = null
 *   var next: Node = null
 *   var child: Node = null
 * }
 */
  class Node(var _value: Int) {
    var value: Int = _value
    var prev: Node = _
    var next: Node = _
    var child: Node = _
  }
  
  def flatten(head: Node): Node = {
    
    def dfs(p: Node): Node = {
      var q = p
      var prev: Node = null
      while (q != null) {
        val (next, child) = (q.next, q.child)
        if (child != null) {
          val last = dfs(child)
          q.next = child
          child.prev = q
          q.child = null
          last.next = next
          if (next != null) next.prev = last
          prev = last
        } else prev = q
        q = next
      }
      prev
    }

    dfs(head)
    head
  }
}