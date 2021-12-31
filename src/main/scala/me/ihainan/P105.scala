package me.ihainan

object P105 {

  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    var index = 0
    val map = inorder.zipWithIndex.toMap

    def build(l: Int, r: Int): TreeNode = {
      if (l > r) null
      else {
        val root = new TreeNode(preorder(index))
        val m = map(preorder(index))
        index += 1
        root.left = build(l, m - 1)
        root.right = build(m + 1, r)
        root
      }
    }

    build(0, inorder.length - 1)
  }
}