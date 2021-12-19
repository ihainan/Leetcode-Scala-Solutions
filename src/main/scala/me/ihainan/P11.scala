package me.ihainan

object P11 {
  def maxArea(height: Array[Int]): Int = {
    var (l, r) = (0, height.length - 1)
    var ans = 0
    while (l < r) {
      ans = ans.max(height(l).min(height(r)) * (r - l))
      if (height(l) <= height(r)) l += 1
      else r -= 1
    }
    ans
  }
}
