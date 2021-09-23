package me.ihainan

/**
  * Definition for a binary tree node.
  * class TreeNode(var _value: Int) {
  *   var value: Int = _value
  *   var left: TreeNode = null
  *   var right: TreeNode = null
  * }
  */
object R0405 {
  def isValidBST(root: TreeNode): Boolean = {
    solve(Long.MinValue, Long.MaxValue, root)
  }

  def solve(min: Long, max: Long, root: TreeNode): Boolean = {
    if (root == null) true
    else if (root.value >= max || root.value <= min) false
    else solve(min, root.value, root.left) && solve(root.value, max, root.right)
  }
}