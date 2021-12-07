package me.ihainan

object P572 {
  def isSubtree(root: TreeNode, subRoot: TreeNode): Boolean = {
    if (root == null && subRoot == null) true
    else if (root == null || subRoot == null) false
    else if (sameTree(root, subRoot)) true
    else isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
  }

  def sameTree(r1: TreeNode, r2: TreeNode): Boolean = {
    if (r1 == null && r2 == null) true
    else if (r1 == null || r2 == null) false
    else if (r1.value != r2.value) false
    else sameTree(r1.left, r2.left) && sameTree(r1.right, r2.right)
  }
}
