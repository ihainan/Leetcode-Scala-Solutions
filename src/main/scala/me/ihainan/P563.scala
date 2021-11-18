package me.ihainan

object P563 {
  def findTilt(root: TreeNode): Int = {
    var ans = 0

    def sum(root: TreeNode): Int = {
      if (root == null) 0
      else {
        val left = sum(root.left)
        val right = sum(root.right)
        ans += (left - right).abs
        left + right + root.value
      }
    }

    sum(root)
    ans
  }
}