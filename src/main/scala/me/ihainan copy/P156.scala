package me.ihainan

object P156 {
  def upsideDownBinaryTree(root: TreeNode): TreeNode = {
    def helper(node: TreeNode): (TreeNode, TreeNode) = {
      if (node == null) (null, null)
      else if (node.left == null && node.right == null) (node, node)
      else {
        val (left, leftRight) = helper(node.left)
        val right = node.right
        node.left = null
        node.right = null
        leftRight.left = right
        leftRight.right = node
        (left, node)
      }
    }

    helper(root)._1
  }
}