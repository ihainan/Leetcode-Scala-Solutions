package me.ihainan

object O47 {
  def maxValue(grid: Array[Array[Int]]): Int = {
    val (m, n) = (grid.length, grid.head.length)
    var tmp = 0
    val dp = (0 until n).map { i => tmp += grid(0)(i); tmp }.toArray
    (1 until m).foreach { i =>
      (0 until n).foreach { j =>
        if (j == 0) dp(j) = dp(j) + grid(i)(j)
        else dp(j) = dp(j).max(dp(j - 1)) + grid(i)(j)
      }
    }
    dp(n - 1)
  }
}