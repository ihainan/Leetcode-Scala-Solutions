package me.ihainan

object P1004Solution2 {
  def longestOnes(nums: Array[Int], k: Int): Int = {
    var tmp = 0
    val sum = nums.map { num => tmp += num; tmp }

    def numOfZeros(l: Int, r: Int): Int = {
      val total = r - l + 1
      if (l == 0) total - sum(r) else total - sum(r) + sum(l - 1)
    }

    @annotation.tailrec
    def find(start: Int, l: Int, r: Int): Int = {
      if (l > r) -1
      else if (numOfZeros(start, r) <= k) r
      else {
        val m = (l + r) >>> 1
        if (numOfZeros(start, m) <= k) find(start, m, r - 1)
        else find(start, l, m - 1)
      }
    }

    nums.indices.map { i =>
      find(i, i, nums.length - 1) - i + 1
    }.max
  }
}
