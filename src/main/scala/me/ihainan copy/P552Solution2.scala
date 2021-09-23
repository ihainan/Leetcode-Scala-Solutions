package me.ihainan

object P552Solution2 {
  val MOD = 1000000007

  def modSum(nums: Int*): Int = {
    var sum = 0
    nums.map { num => sum = (sum + num) % MOD }
    sum
  }

  def checkRecord(n: Int): Int = {
    // 0A + 0L, 0A + 1L, 0A + 2L
    // 1A + 0L, 1A + 1L, 1A + 2L
    var dp = Array(1, 1, 0, 1, 0, 0)
    (1 until n).foreach { _ =>
      val tmp = new Array[Int](6)
      tmp(0) = modSum(dp(0), dp(1), dp(2))
      tmp(1) = dp(0)
      tmp(2) = dp(1)
      tmp(3) = modSum(dp: _*)
      tmp(4) = dp(3)
      tmp(5) = dp(4)
      dp = tmp
    }
    // println(dp.mkString(", "))
    modSum(dp: _*)
  }
}
