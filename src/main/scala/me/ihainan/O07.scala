package me.ihainan

object O07 {

  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    build(preorder, 0, preorder.length - 1,
      inorder, 0, inorder.length - 1, inorder.zipWithIndex.toMap)
  }

  def build(preorder: Array[Int], pl: Int, pr: Int,
            inorder: Array[Int], il: Int, ir: Int, inMap: Map[Int, Int]): TreeNode = {
    if (il > ir) null
    else {
      val rootValue = preorder(pl)
      val im = inMap(rootValue)
      val leftNum = im - il
      val rightNum = ir - im
      val root = new TreeNode(rootValue)
      root.left = build(preorder, pl + 1, pl + leftNum, inorder, il, im - 1, inMap)
      root.right = build(preorder, pl + leftNum + 1, pl + leftNum + rightNum, inorder, im + 1, ir, inMap)
      root
    }
  }
}