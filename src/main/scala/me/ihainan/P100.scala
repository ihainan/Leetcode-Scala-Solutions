package me.ihainan

object P100 {
  def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
    if (p == null && q == null) true
    else if (p == null || q == null) false
    else p.value == q.value && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
  }
}