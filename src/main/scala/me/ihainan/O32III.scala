package me.ihainan

object O32III {
  def levelOrder(root: TreeNode): List[List[Int]] = {
    if (root == null) Nil
    else {
      val ans = collection.mutable.ListBuffer.empty[List[Int]]
      val queue = collection.mutable.Queue(root)
      var leftToRight = true
      while (queue.nonEmpty) {
        val list = collection.mutable.ListBuffer.empty[TreeNode]
        while (queue.nonEmpty) list += queue.dequeue
        if (leftToRight) ans += list.map(_.value).toList else ans += list.map(_.value).toList.reverse
        list.foreach { node =>
          if (node.left != null) queue.enqueue(node.left)
          if (node.right != null) queue.enqueue(node.right)
        }
        leftToRight = !leftToRight
      }
      ans.toList
    }
  }
}