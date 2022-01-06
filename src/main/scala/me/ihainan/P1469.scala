package me.ihainan

object P1469 {
  def getLonelyNodes(root: TreeNode): List[Int] = {
    val ans = collection.mutable.ListBuffer.empty[Int]

    def solve(root: TreeNode): Unit = {
      if (root != null && (root.left != null || root.right != null)) {
        if (root.right == null) ans += root.left.value
        if (root.left == null) ans += root.right.value
        solve(root.left)
        solve(root.right)
      }
    }

    solve(root)
    ans.toList
  }
}
