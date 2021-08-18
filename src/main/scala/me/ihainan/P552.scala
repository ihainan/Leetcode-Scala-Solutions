package me.ihainan

object P552 {
  val MOD = 1000000007

  def modSum(nums: Int*): Int = {
    var sum = 0
    nums.map { num => sum = (sum + num) % MOD }
    sum
  }

  def checkRecord(n: Int): Int = {
    var dp = Array(1, 1, 0, 1, 0, 0, 0) 
    (1 until n).foreach { _ =>
      val tmp = new Array[Int](7)
      tmp(0) = modSum(dp(1), dp(3), dp(4))
      tmp(1) = modSum(dp(1), dp(3), dp(4))
      tmp(2) = modSum(dp(2), dp(0), dp(5), dp(6))
      tmp(3) = dp(1)
      tmp(4) = dp(3)
      tmp(5) = modSum(dp(0), dp(2))
      tmp(6) = dp(5)
      dp = tmp
    }
    modSum(dp: _*)
  }
}
