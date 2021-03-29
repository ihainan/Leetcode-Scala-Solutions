package me.ihainan

object P94Stack {
  def inorderTraversal(root: TreeNode): List[Int] = {
    var p = root
    val stack = collection.mutable.Stack.empty[TreeNode]
    val ans = collection.mutable.ListBuffer.empty[Int]

    while (p != null || stack.nonEmpty) {
      while (p != null) {
        stack.push(p)
        p = p.left
      }

      val q = stack.pop
      ans += q.value
      p = q.right
    }

    ans.toList
  }
}