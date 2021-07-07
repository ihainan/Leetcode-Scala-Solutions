package me.ihainan

object P256Solution2 {
  def findMinValues(nums: Array[Int]): (Int, Int) = {
    var (min, mmin) = (Int.MaxValue, Int.MaxValue)
    nums.foreach { num =>
      if (num < min) {
        mmin = min
        min = num
      } else if (num < mmin) mmin = num
    }

    (min, mmin)
  }

  def minCostII(costs: Array[Array[Int]]): Int = {
    val (n, k) = (costs.length, costs.head.length)
    val dp = costs.head.map(x => x)
    (1 until n).foreach { i =>
      val (min, mmin) = findMinValues(dp)
      (0 until k).foreach { j =>
        if (dp(j) == min) dp(j) = mmin + costs(i)(j)
        else dp(j) = min + costs(i)(j)
      }
    }
    dp.min
  }
}