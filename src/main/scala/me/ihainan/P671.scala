package me.ihainan

object P671 {
  /**
    * Definition for a binary tree node.
    * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    *   var value: Int = _value
    *   var left: TreeNode = _left
    *   var right: TreeNode = _right
    * }
    */
  def findSecondMinimumValue(root: TreeNode): Int = {
    var ans = -1

    def visit(node: TreeNode): Unit = {
      if (node != null) {
        if (ans == -1 || node.value < ans) {
          if (node.value > root.value) ans = node.value
          visit(node.left)
          visit(node.right)
        }
      }
    }

    visit(root)
    ans
  }
}