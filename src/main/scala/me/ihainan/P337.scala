package me.ihainan

object P337 {
  def rob(root: TreeNode): Int = {
    def dfs(node: TreeNode): (Int, Int) = {
      if (node == null) (0, 0)
      else {
        val left = dfs(node.left)
        val right = dfs(node.right)
        val dp0 = left._1.max(left._2) + (right._1.max(right._2))
        val dp1 = node.value + left._1 + right._1
        (dp0, dp1)
      }
    }

    val ans = dfs(root)
    ans._1.max(ans._2)
  }
}