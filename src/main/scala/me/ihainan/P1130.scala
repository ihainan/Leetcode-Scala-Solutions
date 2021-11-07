package me.ihainan

object P1130 {
  def mctFromLeafValues(arr: Array[Int]): Int = {
    val dp = Array.fill(arr.length, arr.length)(Int.MaxValue)
    val maxArray = Array.fill(arr.length, arr.length)(0)

    arr.indices.foreach { i =>
      var max = arr(i)
      (i until arr.length).foreach { j =>
        max = max.max(arr(j))
        maxArray(i)(j) = max
      }
    }

    (1 to arr.length).foreach { len =>
      (0 to arr.length - len).foreach { i =>
        val j = i + len - 1
        if (len == 1) dp(i)(j) = 0
        else {
          (i to j - 1).foreach { k =>
            dp(i)(j) = dp(i)(j).min(
              dp(i)(k) + dp(k + 1)(j) + maxArray(i)(k) * maxArray(k + 1)(j)
            )
          }
        }
      }
    }

    dp(0)(arr.length - 1)
  }
}
