package me.ihainan

object P1305 {

  import collection.mutable.ArrayBuffer

  def getAllElements(root1: TreeNode, root2: TreeNode): List[Int] = {
    def visit(node: TreeNode, list: ArrayBuffer[Int]): Unit = {
      if (node != null) {
        visit(node.left, list)
        list += node.value
        visit(node.right, list)
      }
    }

    val l1 = ArrayBuffer.empty[Int]
    val l2 = ArrayBuffer.empty[Int]
    visit(root1, l1)
    visit(root2, l2)

    var (i, j) = (0, 0)
    val ans = ArrayBuffer.empty[Int]
    while (i != l1.length || j != l2.length) {
      if (i == l1.length || (j != l2.length && l2(j) <= l1(i))) {
        ans += l2(j)
        j += 1
      } else {
        ans += l1(i)
        i += 1
      }
    }

    ans.toList
  }
}
