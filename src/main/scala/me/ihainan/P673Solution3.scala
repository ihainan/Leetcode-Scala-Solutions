package me.ihainan

object P673Solution3 {
  def findNumberOfLIS(nums: Array[Int]): Int = {
    val d = collection.mutable.ArrayBuffer.empty[List[Int]]
    val cnt = collection.mutable.ArrayBuffer.empty[List[Int]]

    d += List(Int.MinValue)
    cnt += List(1)

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
      val index = find1(1, d.length - 1, num)
      if (index == -1) {
        // add new element
        val index2 = find2(d.length - 1, 0, d.last.length - 1, num)
        val count = if (index2 == -1) cnt.last.last else cnt.last.last - cnt.last(index2)
        d += List(num)
        cnt += List(count)
      } else {
        // update existing element
        val index2 = find2(index - 1, 0, d(index - 1).length - 1, num)
        val count = if (index2 == -1) cnt(index - 1).last else cnt(index - 1).last - cnt(index - 1)(index2)
        d(index) = d(index) :+ num
        cnt(index) = cnt(index) :+ (cnt(index).last + count)
      }
    }

    cnt.last.last
  }
}