package me.ihainan

object P376Solution4 {
  def wiggleMaxLength(nums: Array[Int]): Int = {
    var ans = 1
    var i = 0
    while (i < nums.length - 1) {
      var j = i
      while (j < nums.length - 1 && nums(j + 1) >= nums(j)) j += 1
      if (nums(i) != nums(j)) ans += 1
      i = j
      while (j < nums.length - 1 && nums(j + 1) <= nums(j)) j += 1
      if (nums(i) != nums(j)) ans += 1
      i = j
    }
    ans
  }
}
