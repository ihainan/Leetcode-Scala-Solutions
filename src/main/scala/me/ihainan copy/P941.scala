package me.ihainan

object P941 {
  def validMountainArray(nums: Array[Int]): Boolean = {
    if (nums.length < 3) false
    else {
      var i = 1
      while (i != nums.length && nums(i) > nums(i - 1)) i += 1
      if (i == 1 || i == nums.length) return false
      while (i != nums.length && nums(i) < nums(i - 1)) i += 1
      i == nums.length
    }
  }
}
