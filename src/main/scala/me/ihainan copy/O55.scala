package me.ihainan

object O55 {
  def maxDepth(root: TreeNode): Int = {
    if (root == null) 0
    else maxDepth(root.left).max(maxDepth(root.right)) + 1
  }
}