package me.ihainan

object P1879 {
  def minimumXORSum(nums1: Array[Int], nums2: Array[Int]): Int = {
    val map = collection.mutable.Map.empty[(Int, Int), Int]
    nums1.indices.foreach { i =>
      nums2.indices.foreach { j =>
        map((i, j)) = nums1(i) ^ nums2(j)
      }
    }

    val n = nums1.length
    val maxNum = 1 << n
    val dp = Array.fill(maxNum)(Int.MaxValue / 2)
    dp(0) = 0
    (1 until maxNum).foreach { mask =>
      val bitCount = Integer.bitCount(mask)
      (0 until n).foreach { i =>
        if (((1 << i) & mask) != 0) {
          dp(mask) = dp(mask).min(dp((1 << i) ^ mask) + map((bitCount - 1, i)))
        }
      }
    }

    dp(maxNum - 1)
  }
}