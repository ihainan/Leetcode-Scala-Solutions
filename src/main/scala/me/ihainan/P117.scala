package me.ihainan

object P117 {
  class Node(value: Int) {
    var left: Node = _
    var right: Node = _
    var next: Node = _
  }
  
  def connect(root: Node): Node = {
    if (root == null) return root
    val queue = collection.mutable.Queue(root)
    while (queue.nonEmpty) {
      val nodes = (0 until queue.size).map(_ => queue.dequeue)
      (0 until nodes.length - 1).foreach(i => nodes(i).next = nodes(i + 1))
      nodes.foreach { node =>
        if (node.left != null) queue.enqueue(node.left)
        if (node.right != null) queue.enqueue(node.right)
      }
    }
    root
  }
}
