package me.ihainan

object P259Solution3 {
  def threeSumSmaller(nums: Array[Int], target: Int): Int = {
    val sorted = nums.sorted
    var ans = 0
    (0 until sorted.length - 2).foreach { i =>
      val newTarget = target - sorted(i)
      var (j, k) = (i + 1, sorted.length - 1)
      while (j < k) {
        if (sorted(j) + sorted(k) < newTarget) {
          ans += k - j
          j += 1
        } else {
          k -= 1
        }
      }
    }
    ans
  }
}