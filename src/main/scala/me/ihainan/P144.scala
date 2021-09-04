package me.ihainan

object P1265 {
  def preorderTraversal(root: TreeNode): List[Int] = {
    if (root == null) Nil
    else root.value :: preorderTraversal(root.left) ::: preorderTraversal(root.right)
  }
}