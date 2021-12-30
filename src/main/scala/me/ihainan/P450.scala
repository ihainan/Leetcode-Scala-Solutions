package me.ihainan

object P450 {
  def deleteNode(root: TreeNode, key: Int): TreeNode = {
    if (root == null) root
    else if (root.value > key) {
      root.left = deleteNode(root.left, key)
      root
    } else if (root.value < key) {
      root.right = deleteNode(root.right, key)
      root
    } else {
      if (root.left == null) root.right
      else if (root.right == null) root.left
      else {
        val rightLeft = root.right.left
        var leftRight = root.left
        while (leftRight.right != null) leftRight = leftRight.right
        leftRight.right = rightLeft
        root.right.left = root.left
        root.right
      }
    }
  }
}
