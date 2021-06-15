package me.ihainan

object P852 {
  def peakIndexInMountainArray(arr: Array[Int]): Int = {
    @annotation.tailrec
    def find(l: Int, r: Int): Int = {
      val mid = (l + r) >>> 1
      if (arr(mid - 1) < arr(mid) && arr(mid) > arr(mid + 1)) mid
      else if (arr(mid - 1) < arr(mid)) find(mid, r)
      else find(l, mid)
    }

    find(0, arr.length - 1)
  }
}