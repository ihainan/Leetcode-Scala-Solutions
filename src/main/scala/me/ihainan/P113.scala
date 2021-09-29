package me.ihainan

object P113 {
  import collection.mutable.ListBuffer
  import collection.JavaConverters._

  def pathSum(root: TreeNode, targetSum: Int): List[List[Int]] = {
    val ans = ListBuffer.empty[List[Int]]
    val list = new java.util.LinkedList[Int]

    def solve(node: TreeNode, sum: Int): Unit = {
      if (node != null) {
        val newSum = sum + node.value
        if (node.left == null && node.right == null) {
          if (newSum == targetSum) ans += list.asScala.toList :+ node.value
        } else {
          list.addLast(node.value)
          solve(node.left, newSum)
          solve(node.right, newSum)
          list.removeLast
        }
      }
    }

    solve(root, 0)
    ans.toList
  }
}
