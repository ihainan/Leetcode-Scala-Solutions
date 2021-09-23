package me.ihainan

object P1062 {
  def longestRepeatingSubstring(s: String): Int = {
    
    def hasDuplicate(m: Int): Boolean = {
      val set = collection.mutable.HashSet.empty[Int]
      (0 to s.length - m).foreach { start =>
        val str = s.substring(start, start + m)
        if (set(str.hashCode)) return true
        else set += str.hashCode
      }
      false
    }

    @annotation.tailrec
    def find(l: Int, r: Int): Int = {
      if (l > r) 0
      else if (hasDuplicate(r)) r
      else {
        val m = (l + r) >>> 1
        if (hasDuplicate(m)) find(m, r - 1)
        else find(l, m - 1)
      }
    }

    find(1, s.length - 1)
  }
}