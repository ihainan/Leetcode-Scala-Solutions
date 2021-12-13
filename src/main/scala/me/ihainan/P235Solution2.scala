package me.ihainan

object P235Solution2 {
  def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
    if (root == null || p == root || q == root) root
    else {
      val left = lowestCommonAncestor(root.left, p, q)
      val right = lowestCommonAncestor(root.right, p, q)
      if (left != null && right != null) root
      else if (left == null) right
      else left
    }
  }
}