package me.ihainan

object P1133 {
  def largestUniqueNumber(nums: Array[Int]): Int = {
    val s1 = collection.mutable.Set.empty[Int]
    val s2 = collection.mutable.Set.empty[Int]

    nums.indices.foreach { i =>
      if (s1(nums(i))) s2 += nums(i)
      s1 += nums(i)
    }

    var max = -1
    nums.indices.foreach { i =>
      if (!s2(nums(i)) && nums(i) > max) max = nums(i)
    }

    max
  }
}