package me.ihainan

object O32II {
  def levelOrder(root: TreeNode): List[List[Int]] = {
    if (root == null) Nil
    else {
      val ans = collection.mutable.ListBuffer.empty[List[Int]]
      val queue = collection.mutable.Queue(root)
      while (queue.nonEmpty) {
        val list = collection.mutable.ListBuffer.empty[TreeNode]
        while (queue.nonEmpty) list += queue.dequeue
        ans += list.map(_.value).toList
        list.foreach { node =>
          if (node.left != null) queue.enqueue(node.left)
          if (node.right != null) queue.enqueue(node.right)
        }
      }
      ans.toList
    }
  }
}