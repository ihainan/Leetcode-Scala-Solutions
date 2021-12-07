package me.ihainan

object P144 {
  def preorderTraversal(root: TreeNode): List[Int] = {
    if (root == null) Nil
    else
      root.value :: preorderTraversal(root.left) ::: preorderTraversal(
        root.right
      )
  }
}
