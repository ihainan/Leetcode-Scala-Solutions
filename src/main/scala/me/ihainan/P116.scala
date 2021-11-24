package me.ihainan

object P116 {

  /** Definition for a Node. class Node(var _value: Int) { var value: Int =
    * _value var left: Node = null var right: Node = null var next: Node = null
    * }
    */

  class Node(val value: Int) {
    var left: Node = _
    var right: Node = _
    var next: Node = _
  }

  def connect(root: Node): Node = {
    if (root == null) return null
    val queue = collection.mutable.Queue(root)
    while (queue.nonEmpty) {
      val list = (0 until queue.size).map(_ => queue.dequeue)
      list.indices.foreach { i =>
        if (i != 0) list(i - 1).next = list(i)
        if (list(i).left != null) queue.enqueue(list(i).left)
        if (list(i).right != null) queue.enqueue(list(i).right)
      }
    }
    root
  }
}
