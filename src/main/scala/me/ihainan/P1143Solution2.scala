package me.ihainan

object P1143Solution2 {
  def longestCommonSubsequence(text1: String, text2: String): Int = {
    val (l1, l2) = (text1.length, text2.length)
    val dp0 = new Array[Int](l2 + 1)
    val dp1 = new Array[Int](l2 + 1)

    (1 to l1).foreach { i =>
      (1 to l2).foreach { j => dp0(j) = dp1(j) }
      (1 to l2).foreach { j =>
        if (text1(i - 1) == text2(j - 1)) dp1(j) = dp0(j - 1) + 1
        else dp1(j) = dp1(j - 1).max(dp0(j))
      }
    }


    dp1(l2)
  }
}