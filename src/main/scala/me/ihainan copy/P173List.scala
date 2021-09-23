package me.ihainan

object P173List {

  class BSTIterator(_root: TreeNode) {
    def bfs(root: TreeNode): List[Int] = {
      if (root == null) Nil
      else bfs(root.left) ::: List(root.value) ::: bfs(root.right)
    }

    val list = bfs(_root)
    val iterator = list.iterator

    def next(): Int = {
      iterator.next()
    }

    def hasNext(): Boolean = {
      iterator.hasNext
    }

  }

  /**
    * Your BSTIterator object will be instantiated and called as such:
    * var obj = new BSTIterator(root)
    * var param_1 = obj.next()
    * var param_2 = obj.hasNext()
    */
}