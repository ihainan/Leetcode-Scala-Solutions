package me.ihainan

object OII069 {
  def peakIndexInMountainArray(arr: Array[Int]): Int = {
    @annotation.tailrec
    def find(l: Int, r: Int): Int = {
      if (l > r) -1
      else if (l == r) l
      else if (arr(l) > arr(l + 1)) l
      else {
        val m = (l + r) >>> 1
        if (arr(m) > arr(m + 1)) find(l + 1, m)
        else find(m + 1, r)
      }
    }

    find(0, arr.length - 1)
  }
}
