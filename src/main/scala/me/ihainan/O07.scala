package me.ihainan

object O07 {

  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    build(preorder, inorder, inorder.zipWithIndex.toMap, 0, preorder.length - 1, 0, inorder.length - 1)
  }

  def build(preorder: Array[Int], inorder: Array[Int], map: Map[Int, Int], pl: Int, pr: Int, il: Int, ir: Int): TreeNode = {
    if (pl > pr) null
    else {
      val root = new TreeNode(preorder(pl))
      if (pl == pr) root
      else {
        val mid = map(preorder(pl))
        val len = mid - il
        root.left = build(preorder, inorder, map, pl + 1, pl + len, il, mid - 1)
        root.right = build(preorder, inorder, map, pl + len + 1, pr, mid + 1, ir)
        root
      }
    }
  }
}