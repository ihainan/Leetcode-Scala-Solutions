package me.ihainan

object P16 {
  @annotation.tailrec
  def find(sorted: Array[Int], l: Int, r: Int, target: Int): Int = {
    if (l > r) -1
    else if (sorted(r) <= target) r
    else {
      val mid = (l + r) >>> 1
      if (sorted(mid) <= target) find(sorted, mid, r - 1, target) else find(sorted, l, mid - 1, target)
    }
  }

  def threeSumClosest(nums: Array[Int], target: Int): Int = {
    var ans = -1000000
    val sorted = nums.sorted
    (0 until sorted.length - 2).foreach { i =>
      (i + 1 until sorted.length - 1).foreach { j =>
        val sum = sorted(i) + sorted(j)
        var k = find(sorted, j + 1, sorted.length - 1, target - sum)
        if (k == -1) k = j
        if (k != j && (target - ans).abs > (target - sum - sorted(k)).abs) ans = sum + sorted(k)
        if (k != sorted.length - 1 && (target - ans).abs > (target - sum - sorted(k + 1)).abs) ans = sum + sorted(k + 1)
      }
    }
    ans
  }
}