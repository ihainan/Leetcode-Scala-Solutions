package me.ihainan

object P743 {
  def networkDelayTime(times: Array[Array[Int]], n: Int, k: Int): Int = {
    val distance = Array.fill(n, n)(Int.MaxValue)
    (0 until n).foreach { i => distance(i)(i) = 0 }
    times.foreach { time => distance(time(0) - 1)(time(1) - 1) = time(2) }

    (0 until n).foreach { k =>
      (0 until n).foreach { i =>
        (0 until n).foreach { j =>
          if (distance(i)(k) != Int.MaxValue && distance(k)(j) != Int.MaxValue && distance(i)(k) + distance(k)(j) < distance(i)(j)) {
            distance(i)(j) = distance(i)(k) + distance(k)(j)
          }
        }
      }
    }

    val max = distance(k - 1).max
    if (max == Int.MaxValue) -1 else max
  }
}