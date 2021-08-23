package me.ihainan

object P1646 {
  def getMaximumGenerated(n: Int): Int = {
    if (n == 0) return 0
    if (n == 1) return 1
    val nums = new Array[Int](n + 1)
    nums(0) = 0
    nums(1) = 1
    (2 to n).foreach { i =>
      if (i % 2 == 0) nums(i) = nums(i / 2)
      else nums(i) = nums(i / 2) + nums(i / 2 + 1)
    }
    nums.max
  }
}