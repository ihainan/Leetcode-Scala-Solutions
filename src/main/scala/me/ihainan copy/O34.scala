package me.ihainan

object O34 {
  def pathSum(root: TreeNode, target: Int): List[List[Int]] = {
    dfs(root, List.empty[Int], 0, target)
  }

  def dfs(root: TreeNode, path: List[Int], sum: Int, target: Int): List[List[Int]] = {
    if (root == null) Nil
    else if (root.left == null && root.right == null) {
      if (sum + root.value == target) List(path :+ root.value)
      else Nil
    } else dfs(root.left, path :+ root.value, sum + root.value, target) ::: dfs(root.right, path :+ root.value, sum + root.value, target)
  }
}