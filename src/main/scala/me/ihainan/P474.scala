package me.ihainan

object P474 {
  def findMaxForm(strs: Array[String], m: Int, n: Int): Int = {
    val dp = Array.fill(m + 1, n + 1)(0)
    val sumZeros = strs.map(_.count(_ == '0'))
    val sumOnes = strs.map(_.count(_ == '1'))
    var max = 0
    strs.indices.foreach { i =>
      (m to sumZeros(i) by -1).foreach { j =>
        (n to sumOnes(i) by -1).foreach { k =>
          dp(j)(k) = dp(j)(k).max(dp(j - sumZeros(i))(k - sumOnes(i)) + 1)
          max = max.max(dp(j)(k))
        }
      }
    }

    max
  }
}