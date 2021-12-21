package me.ihainan

object P409 {
  def longestPalindrome(s: String): Int = {
    val count = collection.mutable.Map.empty[Char, Int].withDefaultValue(0)
    s.foreach(c => count(c) += 1)

    var maxOdd = ' '
    count.foreach { case (k, v) =>
      if (v % 2 == 1 && (maxOdd == ' ' || v > count(maxOdd))) maxOdd = k
    }

    var ans = 0
    count.foreach { case (k, v) =>
      if (v % 2 == 1 && k != maxOdd) ans += v - 1
      else ans += v
    }
    ans
  }
}
