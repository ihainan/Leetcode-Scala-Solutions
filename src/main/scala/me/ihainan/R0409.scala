package me.ihainan

/**
  * Definition for a binary tree node.
  * class TreeNode(var _value: Int) {
  *   var value: Int = _value
  *   var left: TreeNode = null
  *   var right: TreeNode = null
  * }
  */

import collection.mutable.ListBuffer

object R0409 {
  val ans = ListBuffer.empty[List[Int]]

  def BSTSequences(root: TreeNode): List[List[Int]] = {
    ans.clear
    if (root == null) List(Nil)
    else if (root.left == null && root.right == null) List(List(root.value))
    else {
      if (root.left == null) solve(Set(root.right), List(root.value))
      else if (root.right == null) solve(Set(root.left), List(root.value))
      else solve(Set(root.left, root.right), List(root.value))

      if (ans.isEmpty) List(Nil)
      else ans.toList
    }
  }

  def solve(nodes: Set[TreeNode], path: List[Int]): Unit = {
    if (nodes.isEmpty) ans += path
    else {
      nodes.foreach { node =>
        var newNodes = nodes - node
        if (node.left != null) newNodes += node.left
        if (node.right != null) newNodes += node.right
        solve(newNodes, path :+ node.value)
      }
    }
  }
}