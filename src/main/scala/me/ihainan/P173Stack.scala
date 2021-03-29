package me.ihainan

object P173Stack {


  class BSTIterator(_root: TreeNode) {
    val stack = collection.mutable.Stack.empty[TreeNode]
    var root = _root

    def next(): Int = {
      while (root != null) {
        stack.push(root)
        root = root.left
      }

      val q = stack.pop
      val v = q.value
      root = q.right
      v
    }

    def hasNext(): Boolean = {
      root != null || stack.nonEmpty
    }

  }

}