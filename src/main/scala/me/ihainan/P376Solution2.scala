package me.ihainan

object P376Solution2 {
  def wiggleMaxLength(nums: Array[Int]): Int = {
    val up = Array.fill(nums.length)(1)
    val down = Array.fill(nums.length)(1)
    var ans = 1
    (1 until nums.length).foreach { i =>
      down(i) = down(i - 1)
      up(i) = up(i - 1)
      if (nums(i) > nums(i - 1)) up(i) = down(i - 1) + 1
      else if (nums(i) < nums(i - 1)) down(i) = up(i - 1) + 1
      ans = ans max up(i) max down(i)
    }
    ans
  }
}
