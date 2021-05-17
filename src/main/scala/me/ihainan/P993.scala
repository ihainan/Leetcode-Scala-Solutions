package me.ihainan

object P993 {
  def isCousins(root: TreeNode, x: Int, y: Int): Boolean = {
    val left = find(root, null, x, 0)
    val right = find(root, null, y, 0)
    left != null && right != null && left._1 != right._1 && left._2 == right._2
  }

  def find(node: TreeNode, parent: TreeNode, v: Int, depth: Int): (TreeNode, Int) = {
    if (node == null) null
    else {
      if (node.value == v) (parent, depth)
      else {
        val left = find(node.left, node, v, depth + 1)
        if (left != null) left
        else find(node.right, node, v, depth + 1)
      }
    }
  }
}