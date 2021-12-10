package me.ihainan

object P98Solution2 {
  def isValidBST(root: TreeNode): Boolean = {
    var prev = Long.MinValue
    var flag = true

    def visit(root: TreeNode): Unit = {
      if (flag && root != null) {
        visit(root.left)
        if (prev >= root.value) flag = false
        else {
          prev = root.value
          visit(root.right)
        }
      }
    }

    visit(root)
    flag
  }
}
