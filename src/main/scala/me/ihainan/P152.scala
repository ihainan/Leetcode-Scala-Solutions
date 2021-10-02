package me.ihainan

object P152 {
  def maxProduct(nums: Array[Int]): Int = {
    var ans = Int.MinValue
    var (a, b) = (1, 1)
    nums.foreach { num =>
      val t1 = (a * num) max (b * num) max num
      val t2 = (a * num) min (b * num) min num
      a = t1
      b = t2
      ans = ans max a max b
    }
    ans
  }
}
