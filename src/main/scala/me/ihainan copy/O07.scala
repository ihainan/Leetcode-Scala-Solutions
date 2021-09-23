package me.ihainan

object O07 {
  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    visit(preorder, 0, preorder.length - 1, inorder, inorder.zipWithIndex.toMap, 0, inorder.length - 1)
  }

  def visit(preorder: Array[Int], pl: Int, pr: Int, inorder: Array[Int], map: Map[Int, Int], il: Int, ir: Int): TreeNode = {
    if (pl > pr) null
    else {
      val num = preorder(pl)
      val im = map(num)
      val node = new TreeNode(num)
      node.left = visit(preorder, pl + 1, pl + im - il, inorder, map, il, im - 1)
      node.right = visit(preorder, pl + im - il + 1, pr, inorder, map, im + 1, ir)
      node
    }
  }
}