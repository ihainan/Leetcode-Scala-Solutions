package me.ihainan

object P221 {
  def maximalSquare(matrix: Array[Array[Char]]): Int = {
    val (m, n) = (matrix.length, matrix.head.length)
    var dp = new Array[Int](0)
    var ans = 0
    (0 until m).foreach { i =>
      val tp = new Array[Int](n)
      (0 until n).foreach { j =>
        if (matrix(i)(j) == '0') tp(j) = 0
        else if (i == 0 || j == 0) tp(j) = 1
        else tp(j) = 1 + tp(j - 1).min(dp(j - 1)).min(dp(j))
        ans = ans.max(tp(j))
      }
      dp = tp
    }
    ans * ans
  }
}
