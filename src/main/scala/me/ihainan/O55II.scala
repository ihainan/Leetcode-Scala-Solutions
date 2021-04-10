package me.ihainan

object O55II {
  def isBalanced(root: TreeNode): Boolean = {
    def depth(node: TreeNode): Int = {
      if (node == null) 0
      else {
        val left = depth(node.left)
        val right = depth(node.right)
        if (left == -1 || right == -1 || (left - right).abs > 1) -1
        else left.max(right) + 1
      }
    }

    depth(root) != -1
  }
}