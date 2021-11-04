package me.ihainan

object P238 {
  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    var (t1, t2) = (1, 1)
    val left = nums.map { num => t1 *= num; t1 }
    val right = nums.reverse.map { num => t2 *= num; t2 }.reverse
    nums.indices.map { i =>
      if (i == 0) right(1)
      else if (i == nums.length - 1) left(nums.length - 2)
      else left(i - 1) * right(i + 1)
    }.toArray
  }
}
