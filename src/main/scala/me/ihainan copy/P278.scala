package me.ihainan

object P278 {
  def isBadVersion(version: Int): Boolean = {
    true
  }

  def firstBadVersion(n: Int): Int = {
    @annotation.tailrec
    def search(l: Int, r: Int): Int = {
      if (l == r) l
      else {
        val mid = (l + r) >>> 1
        if (isBadVersion(mid)) search(l, mid)
        else search(mid + 1, r)
      }
    }

    search(1, n)
  }
}