package me.ihainan

object P259 {
  def threeSumSmaller(nums: Array[Int], target: Int): Int = {
    var count = 0
    val sums = collection.mutable.ArrayBuffer.empty[(Int, Int, Int)]
    (0 until nums.length - 1).foreach { i =>
      (i + 1 until nums.length).foreach { j =>
        sums += Tuple3(nums(i) + nums(j), i, j)
      }
    }
    val sorted = sums.sortBy(_._1)
    nums.indices.foreach { i =>
      val filtered = sorted.filter(item => item._2 != i && item._3 != i && i < item._2)
      val newTarget = target - nums(i) - 1 // to find the last number <= newTarget

      @scala.annotation.tailrec
      def find(l: Int, r: Int): Int = {
        if (l > r) -1
        else if (filtered(r)._1 <= newTarget) r
        else {
          val mid = (l + r) >>> 1
          if (filtered(mid)._1 <= newTarget) find(mid, r - 1)
          else find(l, mid - 1)
        }
      }

      val index = find(0, filtered.length - 1)
      count += index + 1
    }
    count
  }
}