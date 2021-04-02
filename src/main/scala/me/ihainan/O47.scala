package me.ihainan

object O47 {
  def maxValue(grid: Array[Array[Int]]): Int = {
    val (m, n) = (grid.length, grid.head.length)
    val dp = Array.ofDim[Int](m, n)
    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        dp(i)(j) =
          if (i == 0 && j == 0) grid(0)(0)
          else if (i == 0) dp(0)(j - 1) + grid(i)(j)
          else if (j == 0) dp(i - 1)(0) + grid(i)(j)
          else dp(i - 1)(j).max(dp(i)(j - 1)) + grid(i)(j)
      }
    }
    dp(m - 1)(n - 1)
  }
}