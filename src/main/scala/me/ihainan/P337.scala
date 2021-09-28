package me.ihainan

object P337 {
  def rob(root: TreeNode): Int = {
    def visit(root: TreeNode): Array[Int] = {
      if (root == null) Array(0, 0)
      else {
        val left = visit(root.left)
        val right = visit(root.right)
        Array(left(1) + right(1) + root.value, left.max + right.max)
      }
    }

    visit(root).max
  }
}
