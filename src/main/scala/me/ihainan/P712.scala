package me.ihainan

object P712 {
  def minimumDeleteSum(s1: String, s2: String): Int = {
    val dp = Array.fill(s1.length + 1, s2.length + 1)(0)
    (1 to s1.length).foreach(i => dp(i)(0) = dp(i - 1)(0) + s1(i - 1).toInt)
    (1 to s2.length).foreach(j => dp(0)(j) = dp(0)(j - 1) + s2(j - 1).toInt)

    (1 to s1.length).foreach { i =>
      (1 to s2.length).foreach { j =>
        if (s1(i - 1) == s2(j - 1)) dp(i)(j) = dp(i - 1)(j - 1)
        else
          dp(i)(j) =
            (dp(i)(j - 1) + s2(j - 1).toInt).min(dp(i - 1)(j) + s1(i - 1).toInt)
      }
    }

    dp.last.last
  }
}
