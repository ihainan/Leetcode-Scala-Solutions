package me.ihainan

/**
  * Definition for a binary tree node.
  * class TreeNode(var _value: Int) {
  *   var value: Int = _value
  *   var left: TreeNode = null
  *   var right: TreeNode = null
  * }
  */
object R0404 {
  def isBalanced(root: TreeNode): Boolean = {
    solve(root)._1
  }

  def solve(root: TreeNode): (Boolean, Int) = {
    if (root == null) (true, 0)
    else {
      val left = solve(root.left)
      val right = solve(root.right)
      val ans = left._1 && right._1 && (left._2 - right._2).abs <= 1
      (ans, left._2.max(right._2) + 1)
    }
  }
}