package me.ihainan

object P1609 {
  def isEvenOddTree(root: TreeNode): Boolean = {
    var evenLevel = true
    val queue = collection.mutable.Queue(root)
    while (queue.nonEmpty) {
      val nodes = queue.indices.map(_ => queue.dequeue)
      var tmp = if (evenLevel) Int.MinValue else Int.MaxValue
      nodes.foreach { node =>
        if (node.left != null) queue.enqueue(node.left)
        if (node.right != null) queue.enqueue(node.right)
        if (
          (evenLevel && node.value % 2 != 1) || (!evenLevel && node.value % 2 != 0)
        ) return false
        if (
          (evenLevel && node.value <= tmp) || (!evenLevel && node.value >= tmp)
        ) return false
        tmp = node.value
      }
      evenLevel = !evenLevel
    }

    true
  }
}
