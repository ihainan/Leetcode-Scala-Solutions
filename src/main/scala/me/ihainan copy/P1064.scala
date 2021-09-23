package me.ihainan

object P1064 {
  def fixedPoint(arr: Array[Int]): Int = {
    @annotation.tailrec
    def find(l: Int, r: Int): Int = {
      if (l > r) -1
      else if (arr(l) == l) l
      else {
        val mid = (l + r) >>> 1
        if (arr(mid) == mid) find(l + 1, mid)
        else if (arr(mid) > mid) find(l + 1, mid - 1)
        else find(mid + 1, r)
      }
    }

    find(0, arr.length - 1)
  }
}