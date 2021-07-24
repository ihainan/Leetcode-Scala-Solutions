package me.ihainan

object P1373 {
  def maxSumBST(root: TreeNode): Int = {
    var ans = 0

    // return (min, max, count, sum)
    def visit(node: TreeNode): (Int, Int, Int, Int) = {
      if (node == null) (0, 0, 0, 0)
      else {
        val left = visit(node.left)
        val right = visit(node.right)
        if (left._3 == -1 || right._3 == -1
          || (left._3 != 0 && node.value <= left._2)
          || (right._3 != 0 && node.value >= right._1)) (0, 0, -1, 0)
        else {
          val min = if (left._3 == 0) node.value else left._1
          val max = if (right._3 == 0) node.value else right._2
          val count = left._3 + right._3 + 1
          val sum = left._4 + right._4 + node.value
          ans = ans.max(sum)
          (min, max, count, sum)
        }
      }
    }

    visit(root)
    ans
  }
}