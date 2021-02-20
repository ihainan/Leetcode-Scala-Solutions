package me.ihainan

/**
  * Definition for a binary tree node.
  * class TreeNode(var _value: Int) {
  *   var value: Int = _value
  *   var left: TreeNode = null
  *   var right: TreeNode = null
  * }
  */
/**
  * Definition for singly-linked list.
  * class ListNode(var _x: Int = 0) {
  *   var next: ListNode = null
  *   var x: Int = _x
  * }
  */

import scala.collection.mutable.{Queue, ArrayBuffer}

// BFS using Queue
object R0403_Recursive {
  def listOfDepth(tree: TreeNode): Array[ListNode] = {
    if (tree == null) Array.empty[ListNode]
    else bfs(List(tree)).toArray
  }

  def bfs(list: List[TreeNode]): List[ListNode] = {
    if (list.isEmpty) Nil
    else {
      val dummy = new ListNode(-1)
      var c = dummy
      list.foreach { node => c.next = new ListNode(node.value); c = c.next }
      dummy.next :: bfs(list.flatMap { node =>
        val left = if (node.left == null) Nil else List(node.left)
        val right = if (node.right == null) Nil else List(node.right)
        left ::: right
      })
    }
  }
}