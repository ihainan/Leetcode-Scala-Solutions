package me.ihainan

object P62 {
  def uniquePaths(m: Int, n: Int): Int = {
    var dp = Array.fill(n)(1)
    (1 until m).foreach { i =>
      val tp = new Array[Int](n)
      (0 until n).foreach { j =>
        if (j == 0) tp(j) = 1 else tp(j) = dp(j) + tp(j - 1)
      }
      dp = tp
    }
    dp.last
  }
}
