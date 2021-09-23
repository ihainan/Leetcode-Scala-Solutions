package me.ihainan

object P1655 {
  def canDistribute(nums: Array[Int], quantity: Array[Int]): Boolean = {
    val map = collection.mutable.Map.empty[Int, Int].withDefaultValue(0)
    nums.foreach(num => map(num) = map(num) + 1)
    val cnt = map.values.toArray
    val (m, n) = (cnt.length, quantity.length)
    val maxNum = 1 << n
    val dp = Array.fill(m + 1, maxNum)(false)
    (0 to m).foreach(i => dp(i)(0) = true)
    dp(0)(0) = true

    (1 to m).foreach { i =>
      (1 until maxNum).foreach { mask =>
        var subset = mask
        var flag = false
        var count = 0
        val bitCount = Integer.bitCount(mask)
        while (!flag && count < (1 << bitCount)) {
          if (dp(i - 1)(subset)) {
            val diff = mask - subset
            val reqQuantity = (0 until n)
              .map(j => if (((1 << j) & diff) != 0) quantity(j) else 0)
              .sum
            if (reqQuantity <= cnt(i - 1)) flag = true
          }
          subset = (subset - 1) & mask
          count += 1
        }
        dp(i)(mask) = flag
      }
    }

    dp(m)(maxNum - 1)
  }
}
