package me.ihainan

object P45Solution2 {
  def jump(nums: Array[Int]): Int = {
    var (s, e, step, max) = (0, 0, 0, 0)
    if (max >= nums.length - 1) return step
    while (s < nums.length) {
      (s to e).foreach { i => max = max.max(i + nums(i)) }
      s = e + 1
      e = max
      step += 1
      if (max >= nums.length - 1) return step
    }
    step
  }
}