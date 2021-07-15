package me.ihainan

object P285 {
  def inorderSuccessor(root: TreeNode, p: TreeNode): TreeNode = {
    var ans: TreeNode = null
    var prev: TreeNode = null

    def visit(node: TreeNode): Unit = {
      if (ans == null) {
        if (node != null) {
          visit(node.left)
          if (ans == null) {
            if (prev == p) ans = node
            prev = node
          }
          visit(node.right)
        }
      }
    }

    visit(root)
    ans
  }
}
