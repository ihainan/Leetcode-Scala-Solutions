package me.ihainan

object O48 {
  def lengthOfLongestSubstring(s: String): Int = {
    var (i, ans) = (0, 0)
    val set = collection.mutable.Set.empty[Char]
    s.indices.foreach { j =>
      while (set(s(j))) {
        set -= s(i)
        i += 1
      }
      set += s(j)
      ans = ans.max(j - i + 1)
    }
    ans
  }
}