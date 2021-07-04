package me.ihainan

object P3 {
  def lengthOfLongestSubstring(s: String): Int = {
    var i = 0
    var ans = 0
    val set = collection.mutable.Set.empty[Char]
    s.indices.foreach { j =>
      while (i < j && set(s(j))) {
        set -= s(i)
        i += 1
      }
      set += s(j)
      ans = ans.max(j - i + 1)
    }
    ans
  }
}