package me.ihainan

object P863 {
  def distanceK(root: TreeNode, target: TreeNode, k: Int): List[Int] = {
    def findParent(node: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
      if (node == null) null
      else if (node == p || node == q) node
      else {
        val left = findParent(node.left, p, q)
        val right = findParent(node.right, p, q)
        if (left != null && right != null) node
        else if (left != null) left
        else right
      }
    }

    def getDistance(node: TreeNode, child: TreeNode, depth: Int): Int = {
      if (node == null) -1
      else if (node == child) depth
      else getDistance(node.left, child, depth + 1) max getDistance(node.right, child, depth + 1)
    }

    val ans = collection.mutable.ListBuffer.empty[Int]

    def visit(node: TreeNode): Unit = {
      if (node != null) {
        val parent = findParent(root, node, target)
        val (d1, d2) = (getDistance(parent, node, 0), getDistance(parent, target, 0))
        if ((parent == target || parent == node) && (d1 - d2).abs == k) ans += node.value
        if (parent != target && parent != node && d1 + d2 == k) ans += node.value
        visit(node.left)
        visit(node.right)
      }
    }

    visit(root)
    ans.toList
  }
}