package me.ihainan

object P376Solution3 {
  def wiggleMaxLength(nums: Array[Int]): Int = {
    var (ans, up, down) = (1, 1, 1)
    (1 until nums.length).foreach { i =>
      var (t1, t2) = (up, down)
      if (nums(i) > nums(i - 1)) t1 = down + 1
      else if (nums(i) < nums(i - 1)) t2 = up + 1
      up = t1
      down = t2
      ans = ans max up max down
    }
    ans
  }
}
