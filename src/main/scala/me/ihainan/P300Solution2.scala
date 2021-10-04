package me.ihainan

object P300Solution2 {
  def lengthOfLIS(nums: Array[Int]): Int = {
    val d = collection.mutable.ArrayBuffer.empty[Int]

    @annotation.tailrec
    def find(l: Int, r: Int, target: Int): Int = {
      if (l > r) -1
      else if (d(l) >= target) l
      else {
        val m = (l + r) >>> 1
        if (d(m) >= target) find(l + 1, m, target) else find(m + 1, r, target)
      }
    }

    nums.foreach { num =>
      val index = find(0, d.length - 1, num)
      if (index == -1) d += num
      else d(index) = num
    }

    d.length
  }
}
