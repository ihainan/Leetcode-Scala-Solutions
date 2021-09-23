package me.ihainan

object P877 {
  def stoneGame(piles: Array[Int]): Boolean = {
    val len = piles.length
    val dp = new Array[Int](len)
    piles.indices.foreach { i => dp(i) = piles(i) }
    (len - 2 to 0 by -1).foreach { i =>
      (i + 1 until len).foreach { j =>
        dp(j) = (piles(i) - dp(j)).max(piles(j) - dp(j - 1))
      }
    }
    dp(len - 1) > 0
  }
}