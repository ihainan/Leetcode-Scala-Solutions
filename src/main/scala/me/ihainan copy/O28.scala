package me.ihainan

object O28 {
  def isSymmetric(root: TreeNode): Boolean = {
    root == null || compare(root.left, root.right)
  }

  def compare(r1: TreeNode, r2: TreeNode): Boolean = {
    if (r1 == null && r2 == null) true
    else if (r1 == null || r2 == null) false
    else r1.value == r2.value && compare(r1.left, r2.right) && compare(r1.right, r2.left)
  }
}