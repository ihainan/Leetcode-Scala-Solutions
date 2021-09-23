package me.ihainan

object P250 {
  /**
    * Definition for a binary tree node.
    * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    *   var value: Int = _value
    *   var left: TreeNode = _left
    *   var right: TreeNode = _right
    * }
    */

  def countUnivalSubtrees(root: TreeNode): Int = {
    var ans = 0

    def helper(node: TreeNode): Int = {
      if (node == null) Int.MaxValue
      else {
        val left = helper(node.left)
        val right = helper(node.right)
        if ((node.left != null && left == Int.MaxValue) || (node.right != null && right == Int.MaxValue)) Int.MaxValue
        else if ((node.left == null || left == node.value) && (node.right == null || right == node.value)) {
          ans += 1
          node.value
        } else Int.MaxValue
      }
    }

    helper(root)
    ans
  }
}