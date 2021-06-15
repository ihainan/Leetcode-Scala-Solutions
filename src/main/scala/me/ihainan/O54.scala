package me.ihainan

object O54 {
  def kthLargest(root: TreeNode, k: Int): Int = {
    var ans: TreeNode = null
    var count = 0

    def visit(node: TreeNode): Unit = {
      if (node != null && count < k) {
        visit(node.right)
        count += 1
        if (count == k) ans = node
        visit(node.left)
      }
    }

    visit(root)
    ans.value
  }
}