package me.ihainan

object P530 {
  def getMinimumDifference(root: TreeNode): Int = {
    var ans = Int.MaxValue
    var prev = -1

    def dfs(node: TreeNode): Unit = {
      if (node != null) {
        dfs(node.left)
        if (prev != -1) ans = ans.min((prev - node.value).abs)
        prev = node.value
        dfs(node.right)
      }
    }

    dfs(root)
    ans
  }
}