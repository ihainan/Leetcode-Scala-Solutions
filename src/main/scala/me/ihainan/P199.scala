package me.ihainan

object P199 {
  def rightSideView(root: TreeNode): List[Int] = {
    val ans = collection.mutable.ArrayBuffer.empty[Int]

    def visit(root: TreeNode, level: Int): Unit = {
      if (root != null) {
        if (level >= ans.length) ans += root.value else ans(level) = root.value
        visit(root.left, level + 1)
        visit(root.right, level + 1)
      }
    }

    visit(root, 0)
    ans.toList
  }
}
