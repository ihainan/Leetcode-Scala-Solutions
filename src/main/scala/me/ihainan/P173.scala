package me.ihainan

object P173 {

  class BSTIterator(_root: TreeNode) {

    def toLink(root: TreeNode): (TreeNode, TreeNode) = {
      if (root == null) (null, null)
      else {
        val left = toLink(root.left)
        val right = toLink(root.right)
        root.left = null
        val head =
          if (left._1 == null) root
          else {
            left._2.right = root
            left._1
          }

        val tail =
          if (right._1 == null) root
          else {
            root.right = right._1
            right._2
          }
        (head, tail)
      }
    }

    val head = toLink(_root)._1
    var current = head

    def next(): Int = {
      val x = current.value
      current = current.right
      x
    }

    def hasNext(): Boolean = {
      current != null
    }

  }

  /**
    * Your BSTIterator object will be instantiated and called as such:
    * var obj = new BSTIterator(root)
    * var param_1 = obj.next()
    * var param_2 = obj.hasNext()
    */
}