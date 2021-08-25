package me.ihainan

object P787Solution2 {
  def findCheapestPrice(
      n: Int,
      flights: Array[Array[Int]],
      src: Int,
      dst: Int,
      k: Int
  ): Int = {
    var dp = Array.fill(n)(Int.MaxValue)
    dp(src) = 0

    (0 to k).foreach { _ =>
      val tmp = dp.map(x => x)
      flights.map { flight =>
        val (f, t, c) = (flight(0), flight(1), flight(2))
        if (dp(f) != Int.MaxValue && dp(f) + c < tmp(t)) tmp(t) = dp(f) + c
      }
      dp = tmp
    }

    if (dp(dst) == Int.MaxValue) -1 else dp(dst)
  }
}
