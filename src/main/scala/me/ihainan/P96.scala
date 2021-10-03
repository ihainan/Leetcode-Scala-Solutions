package me.ihainan

object P96 {
  def numTrees(n: Int): Int = {
    val dp = new Array[Int](n + 1)
    dp(0) = 1
    dp(1) = 1

    (2 to n).foreach { i =>
      (0 until i).foreach { j =>
        dp(i) += dp(j) * dp(i - 1 - j)
      }
    }

    dp.last
  }
}
