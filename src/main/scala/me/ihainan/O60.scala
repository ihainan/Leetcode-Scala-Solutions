package me.ihainan

object O60 {
  def dicesProbability(n: Int): Array[Double] = {
    val sum = math.pow(6, n).toInt
    val dp = new Array[Int](6 * n + 1)

    (1 to n).foreach { i =>
      (i * 6 to i by -1).foreach { j =>
        if (i == 1) dp(j) = 1
        else dp(j) = (1 to 6).map(k => if (j - k >= i - 1) dp(j - k) else 0).sum
      }
    }

    (n to n * 6).map(i => dp(i) * 1.0 / sum).toArray
  }
}