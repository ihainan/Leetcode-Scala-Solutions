package me.ihainan

object P1986Solution2 {
  def minSessions(tasks: Array[Int], sessionTime: Int): Int = {
    val maxNum = 1 << tasks.length
    val dp = Array.fill(maxNum)(Int.MaxValue / 2)
    val valid = Array.fill(maxNum)(false)

    (1 until maxNum).foreach { mask =>
      var time = 0
      tasks.indices.foreach { i =>
        if (((1 << i) & mask) != 0) time += tasks(i)
      }
      valid(mask) = sessionTime >= time
    }

    dp(0) = 0
    (1 until maxNum).foreach { mask =>
      var subset = mask
      while (subset != 0) {
        if (valid(subset)) dp(mask) = dp(mask).min(dp(mask ^ subset) + 1)
        subset = (subset - 1) & mask
      }
    }

    dp(maxNum - 1)
  }
}