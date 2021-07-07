package me.ihainan

object P259Solution2 {
  def threeSumSmaller(nums: Array[Int], target: Int): Int = {
    val sorted = nums.sorted
    var ans = 0
    (0 until sorted.length - 2).foreach { i =>
      (i + 1 until sorted.length - 1).foreach { j =>
        val newTarget = target - sorted(i) - sorted(j)

        @scala.annotation.tailrec
        def find(l: Int, r: Int): Int = {
          if (l > r) j
          else if (sorted(r) < newTarget) r
          else {
            val mid = (l + r) >>> 1
            if (sorted(mid) < newTarget) find(mid, r - 1)
            else find(l, mid - 1)
          }
        }

        val index = find(j + 1, nums.length - 1)
        ans += index - j
      }
    }
    ans
  }
}