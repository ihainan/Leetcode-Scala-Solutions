package me.ihainan

object P275 {
  def hIndex(citations: Array[Int]): Int = {
    val len = citations.length

    @annotation.tailrec
    def find(l: Int, r: Int): Int = {
      if (l > r) len
      else if (citations(l) + l - len >= 0) l
      else {
        val mid = (l + r) >>> 1
        if (citations(mid) + mid - len >= 0) find(l + 1, mid)
        else find(mid + 1, r)
      }
    }

    len - find(0, len - 1)
  }
}