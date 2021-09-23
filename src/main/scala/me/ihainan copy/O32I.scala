package me.ihainan

object O32I {
  def levelOrder(root: TreeNode): Array[Int] = {
    if (root == null) Array.empty[Int]
    else {
      val ans = collection.mutable.ArrayBuffer.empty[Int]
      val queue = collection.mutable.Queue(root)
      while (queue.nonEmpty) {
        val node = queue.dequeue
        ans += node.value
        if (node.left != null) queue.enqueue(node.left)
        if (node.right != null) queue.enqueue(node.right)
      }
      ans.toArray
    }
  }
}