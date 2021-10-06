package me.ihainan

object P414Solution2 {
  def thirdMax(nums: Array[Int]): Int = {
    var (a, b, c) = (Long.MinValue, Long.MinValue, Long.MinValue)
    nums.foreach { num =>
      if (num > c) {
        a = b
        b = c
        c = num
      } else if (num > b && num != c) {
        a = b
        b = num
      } else if (num > a && num != c && num != b) a = num
    }
    if (a == Long.MinValue) c.toInt else a.toInt
  }
}
