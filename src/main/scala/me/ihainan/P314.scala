package me.ihainan

object P314 {
  def verticalOrder(root: TreeNode): List[List[Int]] = {
    if (root == null) return Nil
    var (min, max) = (0, 0)
    val map = collection.mutable.Map.empty[Int, List[Int]].withDefaultValue(Nil)
    val queue = collection.mutable.Queue((root, 0))
    while (queue.nonEmpty) {
      val (node, c) = queue.dequeue
      map(c) = map(c) :+ node.value
      min = min.min(c)
      max = max.max(c)
      if (node.left != null) queue.enqueue((node.left, c - 1))
      if (node.right != null) queue.enqueue((node.right, c + 1))
    }

    val ans = new Array[List[Int]](max - min + 1)
    map.foreach { case (k, v) => ans(k - min) = v }
    ans.toList
  }
}