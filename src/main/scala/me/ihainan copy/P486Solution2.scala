package me.ihainan

object P486Solution2 {
  def PredictTheWinner(nums: Array[Int]): Boolean = {
    val len = nums.length
    val dp = Array.fill(len, len)(Int.MinValue)

    def dpValue(i: Int, j: Int): Int = {
      if (i < 0 || j < 0 || i > j) 0
      else dp(i)(j)
    }

    (1 to len).foreach { currentLen =>
      (0 to len - currentLen).foreach { i =>
        val j = i + currentLen - 1
        if (len % 2 == currentLen % 2) {
          dp(i)(j) = (dpValue(i + 1, j) + nums(i)).max(dpValue(i, j - 1) + nums(j))
        } else {
          dp(i)(j) = (dpValue(i + 1, j) - nums(i)).min(dpValue(i, j - 1) - nums(j))
        }
        println(i, j, dp(i)(j))
      }
    }

    dp(0)(len - 1) >= 0
  }
}