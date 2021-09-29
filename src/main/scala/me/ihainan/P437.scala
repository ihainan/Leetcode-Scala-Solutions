package me.ihainan

object P437 {

  /** Definition for a binary tree node. class TreeNode(_value: Int = 0, _left:
    * TreeNode = null, _right: TreeNode = null) { var value: Int = _value var
    * left: TreeNode = _left var right: TreeNode = _right }
    */
  def pathSum(root: TreeNode, targetSum: Int): Int = {
    var ans = 0
    val seen = collection.mutable.Map.empty[Int, Int].withDefaultValue(0)

    def solve(node: TreeNode, sum: Int): Unit = {
      if (node != null) {
        val newSum = sum + node.value
        if (newSum == targetSum) ans += 1
        ans += seen(newSum - targetSum)
        seen(newSum) = seen(newSum) + 1
        solve(node.left, newSum)
        solve(node.right, newSum)
        seen(newSum) = seen(newSum) - 1
      }
    }

    solve(root, 0)
    ans
  }
}
