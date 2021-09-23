package me.ihainan

object P230 {
  def kthSmallest(root: TreeNode, k: Int): Int = {
    var ans: TreeNode = null
    var count = 0

    def helper(node: TreeNode): Unit = {
      if (ans == null && node != null) {
        helper(node.left)
        count += 1
        if (count == k) ans = node
        helper(node.right)
      }
    }

    helper(root)
    ans.value
  }
}
