package me.ihainan

object P334Solution2 {
  def increasingTriplet(nums: Array[Int]): Boolean = {
    var small = Int.MaxValue
    var mid = Int.MaxValue
    nums.foreach { num =>
      if (num <= small) small = num
      else if (num > mid) return true
      else mid = num
    }
    false
  }
}
