package me.ihainan

object P650Solution2 {
  def minSteps(n: Int): Int = {
    if (n == 1) 0
    else {
      val dp = Array.fill(n + 1)(0)
      (2 to n).foreach { i =>
        dp(i) = Int.MaxValue / 2
        var j = 1
        while (j * j <= i) {
          if (i % j == 0) {
            dp(i) = dp(i).min(dp(j) + i / j).min(dp(i / j) + j)
          }
          j += 1
        }
      }
      dp.last
    }
  }
}