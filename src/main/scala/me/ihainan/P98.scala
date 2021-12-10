package me.ihainan

object P98 {
  def isValidBST(root: TreeNode): Boolean = {

    def verify(node: TreeNode, lower: Long, upper: Long): Boolean = {
      if (node == null) true
      else if (node.value <= lower || node.value >= upper) false
      else
        verify(node.left, lower, node.value) && verify(
          node.right,
          node.value,
          upper
        )
    }

    verify(root, Int.MinValue.toLong - 1, Int.MaxValue.toLong + 1)

  }
}
