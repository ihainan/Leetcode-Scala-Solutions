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

import scala.collection.mutable.{ArrayBuffer, Queue}

// BFS using Queue
object R0403_Queue {
  def listOfDepth(tree: TreeNode): Array[ListNode] = {
    val ans = ArrayBuffer.empty[ListNode]
    val queue = Queue.empty[TreeNode]
    queue.enqueue(tree)
    while (queue.nonEmpty) {
      val dummy = new ListNode(-1)
      var c = dummy
      val nodes = ArrayBuffer.empty[TreeNode]
      while (queue.nonEmpty) nodes += queue.dequeue
      nodes.foreach { node =>
        c.next = new ListNode(node.value)
        c = c.next
        if (node.left != null) queue.enqueue(node.left)
        if (node.right != null) queue.enqueue(node.right)
      }
      ans += dummy.next
    }
    ans.toArray
  }
}
