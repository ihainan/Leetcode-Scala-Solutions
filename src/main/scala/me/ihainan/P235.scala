package me.ihainan

object P235 {
  @scala.annotation.tailrec
  def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
    if (root == null) null
    else if (root.value < p.value.min(q.value)) lowestCommonAncestor(root.right, p, q)
    else if (root.value > p.value.max(q.value)) lowestCommonAncestor(root.left, p, q)
    else root
  }
}