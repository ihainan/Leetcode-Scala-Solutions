package me.ihainan

object P611Solution3 {
  def triangleNumber(nums: Array[Int]): Int = {
    val sorted = nums.sorted
    var ans = 0
    (0 to sorted.length - 3).foreach { i =>
      if (sorted(i) != 0) {
        var (j, k) = (i + 1, i + 2)
        while (j != sorted.length - 1) {
          while (k < sorted.length && sorted(k) < sorted(i) + sorted(j)) k += 1
          ans += k - j - 1
          j += 1
        }
      }
    }
    ans
  }
}