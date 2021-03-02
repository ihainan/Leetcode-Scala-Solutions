package me.ihainan

object R0801 {
  def waysToStep(n: Int): Int = {
    if (n == 1) 1
    else if (n == 2) 2
    else if (n == 3) 4
    else {
      var (dp0, dp1, dp2, dp3) = (1, 2, 4, 0)
      (4 to n).foreach { _ =>
        dp3 = (((dp0 + dp1) % 1000000007) + dp2) % 1000000007
        dp0 = dp1
        dp1 = dp2
        dp2 = dp3
      }
      dp3
    }
  }
}