package me.ihainan

object P5 {
  def longestPalindrome(s: String): String = {
    val n = s.length
    val dp = Array.fill(n, n)(false)
    var (l, r) = (0, 0)
    (0 until n).foreach(i => dp(i)(i) = true)
    (2 to n).foreach { i =>
      (0 to n - i).foreach { j =>
        val k = j + i - 1
        if (s(j) == s(k) && (j + 1 == k || dp(j + 1)(k - 1))) {
          dp(j)(k) = true
          l = j
          r = k
        }
      }
    }
    s.substring(l, r + 1)
  }
}
