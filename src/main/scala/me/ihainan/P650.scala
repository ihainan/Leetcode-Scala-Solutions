package me.ihainan

object P650 {
  def minSteps(n: Int): Int = {
    if (n == 1) 0
    else {
      val dp = Array.fill(n + 1)(0)
      (2 to n).foreach { i =>
        var min = Int.MaxValue
        (1 until i).foreach { j =>
          if (i % j == 0) {
            min = min.min(dp(j) + i / j)
          }
        }
        dp(i) = min
      }
      dp.last
    }
  }
}