package me.ihainan

object P298 {
  def longestConsecutive(root: TreeNode): Int = {
    def solve(node: TreeNode, prev: Int, count: Int): Int = {
      if (node == null) count
      else {
        val newCount = if (node.value == prev + 1) count + 1 else 1
        count max solve(node.left, node.value, newCount) max solve(node.right, node.value, newCount)
      }
    }

    if (root == null) 0 else solve(root, root.value - 1, 0)
  }
}