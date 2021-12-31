package me.ihainan

object P173Stack {

  /** Definition for a binary tree node. class TreeNode(_value: Int = 0, _left:
    * TreeNode = null, _right: TreeNode = null) { var value: Int = _value var
    * left: TreeNode = _left var right: TreeNode = _right }
    */
  class BSTIterator(_root: TreeNode) {
    val stack = collection.mutable.Stack.empty[TreeNode]
    var node = _root
    while (node != null) {
      stack.push(node)
      node = node.left
    }

    def next(): Int = {
      var node = stack.pop
      val ans = node.value
      node = node.right
      while (node != null) {
        stack.push(node)
        node = node.left
      }
      ans
    }

    def hasNext(): Boolean = {
      // println(stack.map(_.value).mkString(", "))
      stack.nonEmpty
    }

  }

  /** Your BSTIterator object will be instantiated and called as such: var obj =
    * new BSTIterator(root) var param_1 = obj.next() var param_2 = obj.hasNext()
    */

}
