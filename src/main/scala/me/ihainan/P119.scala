package me.ihainan

object P119 {
  def getRow(rowIndex: Int): List[Int] = {
    val dp = new Array[Int](rowIndex + 1)
    dp(0) = 1
    (1 to rowIndex).foreach { i =>
      (i to 1 by -1).foreach { j =>
        dp(j) += dp(j - 1)
      }
    }
    dp.toList
  }
}
