package me.ihainan

object P333 {

  def largestBSTSubtree(root: TreeNode): Int = {
    var ans = 0

    def visit(node: TreeNode): (Int, Int, Int) = {
      if (node == null) (0, 0, 0)
      else {
        val left = visit(node.left)
        val right = visit(node.right)
        if (left._3 == -1 || right._3 == -1 ||
          (left._3 != 0 && node.value <= left._2) ||
          (right._3 != 0 && node.value >= right._1)) (0, 0, -1)
        else {
          val min = if (left._3 == 0) node.value else left._1
          val max = if (right._3 == 0) node.value else right._2
          val count = left._3 + right._3 + 1
          ans = ans.max(count)
          (min, max, count)
        }
      }
    }

    visit(root)
    ans
  }
}