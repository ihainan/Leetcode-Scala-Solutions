package me.ihainan

object P1567 {
  def getMaxLen(nums: Array[Int]): Int = {
    var (ans, l1, l2) = (0, 0, 0)
    nums.foreach { num =>
      if (num == 0) {
        l1 = 0
        l2 = 0
      } else if (num > 0) {
        l1 += 1
        if (l2 != 0) l2 += 1
      } else {
        val (t1, t2) = (l1, l2)
        l1 = if (t2 != 0) t2 + 1 else 0
        l2 = if (t1 != 0) t1 + 1 else 1
      }
      ans = ans.max(l1)
    }
    ans
  }
}
