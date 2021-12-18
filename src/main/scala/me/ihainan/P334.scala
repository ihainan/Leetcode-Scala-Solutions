package me.ihainan

object P334 {
  def increasingTriplet(nums: Array[Int]): Boolean = {
    var max = nums.last
    val larger = new Array[Boolean](nums.length)
    (nums.length - 1 to 0 by -1).foreach { i =>
      larger(i) = max > nums(i)
      max = max.max(nums(i))
    }

    val less = new Array[Boolean](nums.length)
    var min = nums.head
    (1 until nums.length).foreach { i =>
      less(i) = nums(i) > min
      min = min.min(nums(i))
    }
    
    (1 until nums.length - 1).exists(i => less(i) && larger(i))
  }
}
