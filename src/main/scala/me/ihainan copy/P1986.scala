package me.ihainan

object P1986 {
  def minSessions(tasks: Array[Int], sessionTime: Int): Int = {
    val count = math.pow(2, tasks.length).toInt
    val dp = Array.fill[(Int, Int)](count)((Int.MaxValue, 0))
    dp(0) = (1, sessionTime)

    (1 until count).foreach { mask =>
      (0 until 32).foreach { i =>
        if (((1 << i) & mask) > 0) {
          val submask = (1 << i) ^ mask
          val (ms, mr) = dp(mask)
          val (s, r) = dp(submask)
          val (ns, nr) = if (r >= tasks(i)) (s, r - tasks(i)) else (s + 1, sessionTime - tasks(i))
          if (ms == Int.MaxValue || (ns < ms || (ns == ms && mr < nr))) dp(mask) = (ns, nr)
        }
      }
    }

    dp(count - 1)._1
  }
}