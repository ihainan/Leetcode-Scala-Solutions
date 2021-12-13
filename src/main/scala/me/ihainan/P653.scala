package me.ihainan

object P653 {
  def findTarget(root: TreeNode, k: Int): Boolean = {
    val set = collection.mutable.Set.empty[Int]
    var flag = false

    def visit(root: TreeNode): Unit = {
      if (!flag && root != null) {
        visit(root.left)
        if (set(k - root.value)) flag = true
        else {
          set += root.value
          visit(root.right)
        }
      }
    }

    visit(root)
    flag
  }
}