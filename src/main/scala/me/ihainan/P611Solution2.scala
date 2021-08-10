package me.ihainan

object P611Solution2 {
  def isTriangle(a: Int, b: Int, c: Int): Boolean = {
    (a - b).abs < c && (a - c).abs < b && (b - c).abs < a
  }

  def triangleNumber(nums: Array[Int]): Int = {
    val len = nums.length
    val sorted = nums.sorted
    var ans = 0

    def find(l: Int, r: Int, target: Int): Int = {
      if (l > r) -1
      else if (sorted(r) < target) r
      else {
        val m = (l + r) >>> 1
        if (sorted(m) < target) find(m, r - 1, target) else find(l, m - 1, target)
      }
    }

    (0 until len - 2).foreach { i =>
      (i + 1 until len - 1).foreach { j =>
        val lastIndex = find(j + 1, len - 1, sorted(i) + sorted(j))
        if (lastIndex != -1) {
          ans += (j + 1 to lastIndex).count { k => isTriangle(sorted(i), sorted(j), sorted(k)) }
        }
      }
    }
    ans
  }
}