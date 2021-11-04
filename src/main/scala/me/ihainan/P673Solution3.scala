package me.ihainan

object P673Solution3 {
  import collection.mutable.ArrayBuffer

  def findNumberOfLIS(nums: Array[Int]): Int = {
    val d = ArrayBuffer(ArrayBuffer(Int.MinValue))
    val cnt = ArrayBuffer(ArrayBuffer(1))

    @annotation.tailrec
    def find1(l: Int, r: Int, target: Int): Int = {
      if (l > r) -1
      else if (d(l).last >= target) l
      else {
        val m = (l + r) >>> 1
        if (d(m).last >= target) find1(l + 1, m, target) else find1(m + 1, r, target)
      }
    }

    @annotation.tailrec
    def find2(i: Int, l: Int, r: Int, target: Int): Int = {
      if (l > r) -1
      else if (d(i)(r) >= target) r
      else {
        val m = (l + r) >>> 1
        if (d(i)(m) >= target) find2(i, m, r - 1, target) else find2(i, l, m - 1, target)
      }
    }

    nums.foreach { num =>
      val index1 = find1(1, d.length - 1, num)
      val index2 = if (index1 == -1) d.length - 1 else index1 - 1
      val index3 = find2(index2, 0, d(index2).length - 1, num)
      val add = if (index3 == -1) cnt(index2).last else cnt(index2).last - cnt(index2)(index3)
      if (index1 == -1) {
        d += ArrayBuffer(num)
        cnt += ArrayBuffer(add)
      } else {
        d(index1) += num
        cnt(index1) += (cnt(index1).last + add)
      }
    }

    cnt.last.last
  }
}