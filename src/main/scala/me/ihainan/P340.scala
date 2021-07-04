package me.ihainan

object P340 {
  def lengthOfLongestSubstringKDistinct(s: String, k: Int): Int = {
    val map = collection.mutable.Map.empty[Char, Int].withDefaultValue(0)
    var (ans, i) = (0, 0)
    s.indices.foreach { j =>
      map(s(j)) = map(s(j)) + 1
      while (map.size > k) {
        map(s(i)) = map(s(i)) - 1
        if (map(s(i)) == 0) map -= s(i)
        i += 1
      }
      ans = ans.max(j - i + 1)
    }
    ans
  }
}
