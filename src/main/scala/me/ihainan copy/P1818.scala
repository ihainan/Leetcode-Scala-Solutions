package me.ihainan

object P1818 {
  val MOD = 1000000007

  def minAbsoluteSumDiff(nums1: Array[Int], nums2: Array[Int]): Int = {
    val sorted = nums1.sorted

    @annotation.tailrec
    def findBefore(l: Int, r: Int, target: Int): Int = {
      if (l > r) -1
      else if (sorted(r) <= target) r
      else {
        val mid = (l + r) >>> 1
        if (sorted(mid) <= target) findBefore(mid, r - 1, target) else findBefore(l, mid - 1, target)
      }
    }

    var maxReduce = 0
    var diffSum = 0
    nums1.zip(nums2).foreach { case (num1, num2) =>
      val currentAbs = (num1 - num2).abs
      diffSum = (diffSum + currentAbs) % MOD
      val before = findBefore(0, sorted.length - 1, num2)
      if (before != -1) maxReduce = maxReduce.max(currentAbs - (num2 - sorted(before)).abs)
      if (before != sorted.length - 1) maxReduce = maxReduce.max(currentAbs - (num2 - sorted(before + 1)).abs)
    }

    val newDiff = diffSum - maxReduce
    if (newDiff < 0) MOD + newDiff else newDiff
  }
}