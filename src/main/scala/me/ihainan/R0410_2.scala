package me.ihainan

/**
  * Definition for a binary tree node.
  * class TreeNode(var _value: Int) {
  *   var value: Int = _value
  *   var left: TreeNode = null
  *   var right: TreeNode = null
  * }
  */
object R0410_2 {
  def checkSubTree(t1: TreeNode, t2: TreeNode): Boolean = {
    val s1 = visit(t1)
    val s2 = visit(t2)
    s1.contains(s2)
  }

  def visit(root: TreeNode): String = {
    if (root == null) "#"
    else visit(root.left) + "," + root.value + "," + visit(root.right)
  }
}