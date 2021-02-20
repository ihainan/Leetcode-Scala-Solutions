package me.ihainan

/**
  * Definition for a binary tree node.
  * class TreeNode(var _value: Int) {
  *   var value: Int = _value
  *   var left: TreeNode = null
  *   var right: TreeNode = null
  * }
  */
object R0410 {
  def checkSubTree(t1: TreeNode, t2: TreeNode): Boolean = {
    if (t2 == null) true
    else if (t1 == null) false
    else if (t1.value == t2.value) compare(t1, t2)
    else checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2)
  }

  def compare(t1: TreeNode, t2: TreeNode): Boolean = {
    if (t1 == null && t2 == null) true
    else if (t1 == null || t2 == null) false
    else if (t1.value != t2.value) false
    else compare(t1.left, t2.left) && compare(t1.right, t2.right)
  }
}