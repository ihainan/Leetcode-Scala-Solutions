package me.ihainan

object P272 {

  def closestKValues(root: TreeNode, target: Double, k: Int): List[Int] = {
    val list = collection.mutable.ArrayBuffer.empty[Int]
    val ans = collection.mutable.ListBuffer.empty[Int]
    var first = -1

    def visit(node: TreeNode): Unit = {
      if (node != null) {
        visit(node.left)
        list += node.value
        if (node.value >= target && first == -1) first = list.length - 1
        visit(node.right)
      }
    }

    visit(root)
    if (first == -1) first = list.length
    var (i, j) = (first - 1, first)
    while (!(i == -1 && j == list.length) && ans.size < k) {
      if (j == list.length || (i != -1 && (list(i) - target).abs <= (list(j) - target).abs)) {
        ans += list(i)
        i -= 1
      } else {
        ans += list(j)
        j += 1
      }
    }

    ans.toList
  }
}