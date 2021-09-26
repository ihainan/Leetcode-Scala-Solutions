package me.ihainan

object P673Solution2 {
  def findNumberOfLIS(nums: Array[Int]): Int = {
    val d = collection.mutable.ArrayBuffer.empty[List[Int]]
    val cnt = collection.mutable.ArrayBuffer.empty[List[Int]]
    d += List(Int.MinValue)
    cnt += List(1)

    def find(l: Int, r: Int, target: Int): Int = {
      if (l > r) -1
      else if (d(l).last >= target) l
      else {
        val m = (l + r) >>> 1
        if (d(m).last >= target) find(l + 1, m, target)
        else find(m + 1, r, target)
      }
    }

    nums.foreach { num =>
      val index = find(1, d.length - 1, num)
      if (index == -1) {
        cnt += List(d.last.indices.map(i => if (d.last(i) < num) cnt.last(i) else 0).sum)
        d += List(num)
      } else {
        d(index) = d(index) :+ num
        cnt(index) = cnt(index) :+ d(index - 1).indices.map(i => if (d(index - 1)(i) < num) cnt(index - 1)(i) else 0).sum
      }
    }

    cnt.last.sum
  }
}