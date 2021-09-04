package me.ihainan

object P111 {
  /**
    * Definition for a binary tree node.
    * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    *   var value: Int = _value
    *   var left: TreeNode = _left
    *   var right: TreeNode = _right
    * }
    */
  def minDepth(root: TreeNode): Int = {
    if (root == null) 0
    else if (root.left == null && root.right == null) 1
    else if (root.left == null) minDepth(root.right) + 1
    else if (root.right == null) minDepth(root.left) + 1
    else minDepth(root.left).min(minDepth(root.right)) + 1
  }
}