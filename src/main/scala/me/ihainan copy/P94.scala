package me.ihainan

object P94 {
  def inorderTraversal(root: TreeNode): List[Int] = {
    if (root == null) Nil
    else inorderTraversal(root.left) ::: List(root.value) ::: inorderTraversal(root.right)
  }
}