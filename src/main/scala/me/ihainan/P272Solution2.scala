package me.ihainan

object P272Solution2 {

  import collection.JavaConverters._

  def closestKValues(root: TreeNode, target: Double, k: Int): List[Int] = {
    val queue = new java.util.LinkedList[Int]()

    def visit(node: TreeNode): Unit = {
      if (node != null) {
        visit(node.left)
        if (queue.size < k) queue.addLast(node.value)
        else {
          if ((node.value - target).abs < (queue.getFirst - target).abs) {
            queue.removeFirst()
            queue.addLast(node.value)
          } else return
        }
        visit(node.right)
      }
    }

    visit(root)
    queue.asScala.toList
  }
}