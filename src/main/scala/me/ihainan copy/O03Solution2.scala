package me.ihainan

object O03Solution2 {
  def findRepeatNumber(nums: Array[Int]): Int = {
    var i = 0
    while (i < nums.length) {
      val num = nums(i)
      if (num == i) i += 1
      else {
        if (nums(num) == num) return num
        else {
          val tmp = nums(num)
          nums(num) = num
          nums(i) = tmp
        }
      }
    }
    -1
  }
}