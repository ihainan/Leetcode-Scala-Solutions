package me.ihainan

object P366 {
  /**
    * Definition for a binary tree node.
    * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    *   var value: Int = _value
    *   var left: TreeNode = _left
    *   var right: TreeNode = _right
    * }
    */

  import collection.mutable.ListBuffer

  def findLeaves(root: TreeNode): List[List[Int]] = {

    def remove(node: TreeNode, parent: TreeNode, list: ListBuffer[Int], isLeft: Boolean): Unit = {
      if (node != null) {
        if (node.left == null && node.right == null) {
          list += node.value
          if (parent != null) {
            if (isLeft) parent.left = null
            else parent.right = null
          }
        } else {
          remove(node.left, node, list, true)
          remove(node.right, node, list, false)
        }
      }
    }


    if (root == null) Nil
    else {
      val ans = ListBuffer.empty[List[Int]]
      while (root.left != null || root.right != null) {
        val list = ListBuffer.empty[Int]
        remove(root, null, list, true)
        ans += list.toList
      }
      ans += List(root.value)
      ans.toList
    }
  }
}