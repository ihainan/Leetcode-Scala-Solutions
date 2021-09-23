package me.ihainan

object P265Solution2 {
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
    var vs = findMinValues(dp)
    (1 until n).foreach { i =>
      (0 until k).foreach { j =>
        if (dp(j) == vs._1) dp(j) = vs._2 + costs(i)(j)
        else dp(j) = vs._1 + costs(i)(j)
      }
      vs = findMinValues(dp)
    }
    dp.min
  }
}