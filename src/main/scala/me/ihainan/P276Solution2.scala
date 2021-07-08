package me.ihainan

object P276Solution2 {
  def numWays(n: Int, k: Int): Int = {
    var (dp0, dp1) = (0, k)
    (1 until n).foreach { _ =>
      val (tmp0, tmp1) = (dp0, dp1)
      dp0 = tmp1
      dp1 = (k - 1) * (tmp0 + tmp1)
    }
    dp0 + dp1
  }
}