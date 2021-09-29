package me.ihainan

object P112 {

  /** Definition for a binary tree node. class TreeNode(_value: Int = 0, _left:
    * TreeNode = null, _right: TreeNode = null) { var value: Int = _value var
    * left: TreeNode = _left var right: TreeNode = _right }
    */
  def hasPathSum(root: TreeNode, targetSum: Int): Boolean = {
    def solve(node: TreeNode, sum: Int): Boolean = {
      if (node == null) false
      else if (node.left == null && node.right == null)
        sum + node.value == targetSum
      else
        solve(node.left, sum + node.value) || solve(
          node.right,
          sum + node.value
        )
    }

    solve(root, 0)
  }
}
