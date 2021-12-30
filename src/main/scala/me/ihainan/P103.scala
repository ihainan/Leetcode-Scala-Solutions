package me.ihainan

object P103 {
  def zigzagLevelOrder(root: TreeNode): List[List[Int]] = {
    if (root == null) return Nil
    var leftToRight = true
    val queue = collection.mutable.Queue(root)
    val ans = collection.mutable.ListBuffer.empty[List[Int]]
    while (queue.nonEmpty) {
      val level = collection.mutable.ArrayDeque.empty[Int]
      queue.indices.foreach { _ =>
        val next = queue.dequeue
        if (leftToRight) level.append(next.value) else level.prepend(next.value)
        if (next.left != null) queue.enqueue(next.left)
        if (next.right != null) queue.enqueue(next.right)
      }
      ans += level.toList
      leftToRight = !leftToRight
    }
    ans.toList
  }
}
