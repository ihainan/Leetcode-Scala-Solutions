package me.ihainan

object P64 {
  def minPathSum(grid: Array[Array[Int]]): Int = {
    val (m, n) = (grid.length, grid.head.length)
    var dp = Array.fill(n)(Int.MaxValue)
    (0 until m).foreach { i =>
      val tp = new Array[Int](n)
      (0 until n).foreach { j =>
        if (i == 0 && j == 0) tp(j) = grid(i)(j)
        else if (j == 0) tp(j) = dp(j) + grid(i)(j)
        else tp(j) = dp(j).min(tp(j - 1)) + grid(i)(j)
      }
      dp = tp
    }
    dp.last
  }
}
