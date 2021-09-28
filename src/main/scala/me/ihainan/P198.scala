package me.ihainan

object P198 {
  def rob(nums: Array[Int]): Int = {
    var (a, b) = (nums.head, 0)
    (1 until nums.length).foreach { i =>
      val t1 = b + nums(i)
      val t2 = a.max(b)
      a = t1
      b = t2
    }
    a.max(b)
  }
}