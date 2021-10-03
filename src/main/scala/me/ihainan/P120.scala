package me.ihainan

object P120 {
  def minimumTotal(triangle: List[List[Int]]): Int = {
    var dp = triangle.head.toArray
    (1 until triangle.length).foreach { i =>
      val tp = Array.fill(i + 1)(Int.MaxValue)
      (0 to i).foreach { j =>
        if (j != 0) tp(j) = tp(j).min(dp(j - 1))
        if (j != i) tp(j) = tp(j).min(dp(j))
        tp(j) += triangle(i)(j)
      }
      dp = tp
    }
    dp.min
  }
}
