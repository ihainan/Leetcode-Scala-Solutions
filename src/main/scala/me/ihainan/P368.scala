package me.ihainan

object P368 {
  def largestDivisibleSubset(nums: Array[Int]): List[Int] = {
    val sorted = nums.sorted
    val dp = Array.fill(sorted.length)(1)
    val path = sorted.map(num => List(num))
    var max = 1
    (1 until sorted.length).foreach { i =>
      (0 until i).foreach { j =>
        if (sorted(i) % sorted(j) == 0 && dp(i) < dp(j) + 1) {
          dp(i) = dp(j) + 1
          path(i) = path(j) :+ sorted(i)
        }
      }
      max = max.max(dp(i))
    }

    dp.indices
      .collectFirst { case i if (dp(i) == max) => path(i) }
      .getOrElse(Nil)
  }
}
