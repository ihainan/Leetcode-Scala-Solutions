package me.ihainan

object P863Solution2 {
  /**
    * Definition for a binary tree node.
    * class TreeNode(var _value: Int) {
    *   var value: Int = _value
    *   var left: TreeNode = null
    *   var right: TreeNode = null
    * }
    */
  def distanceK(root: TreeNode, target: TreeNode, k: Int): List[Int] = {
    val parents = collection.mutable.Map.empty[Int, TreeNode]
    val ans = collection.mutable.ListBuffer.empty[Int]

    def findParents(node: TreeNode, from: TreeNode): Unit = {
      if (node != null) {
        parents(node.value) = from
        findParents(node.left, node)
        findParents(node.right, node)
      }
    }

    def search(node: TreeNode, depth: Int, from: TreeNode): Unit = {
      if (node != null && depth <= k) {
        if (depth == k) ans += node.value
        Array(node.left, node.right, parents(node.value)).foreach { next => if (next != from) search(next, depth + 1, node) }
      }
    }

    findParents(root, null)
    search(target, 0, null)
    ans.toList
  }
}