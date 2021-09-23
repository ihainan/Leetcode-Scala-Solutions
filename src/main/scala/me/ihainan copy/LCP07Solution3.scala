package me.ihainan

object LCP07Solution3 {
  def numWays(n: Int, relation: Array[Array[Int]], k: Int): Int = {
    var dp = new Array[Int](n)
    dp(0) = 1

    (1 to k).foreach { i =>
      val next = new Array[Int](n)
      relation.foreach { arr =>
        next(arr(1)) += dp(arr(0))
      }
      dp = next
    }

    dp(n - 1)
  }
}