package me.ihainan

object P743Solution2 {
  def networkDelayTime(times: Array[Array[Int]], n: Int, k: Int): Int = {
    val dist = Array.fill(n)(Int.MaxValue)
    val map = times.map { time => (time(0) - 1, time(1) - 1) -> time(2) }.toMap.withDefaultValue(Int.MaxValue)
    val visited = collection.mutable.Set.empty[Int]
    dist(k - 1) = 0
    (0 until n).foreach { _ =>
      var i = -1
      (0 until n).foreach { j => if (!visited(j) && (i == -1 || dist(j) < dist(i))) i = j }
      visited += i
      (0 until n).foreach { j =>
        if (dist(i) != Int.MaxValue && map((i, j)) != Int.MaxValue) dist(j) = dist(j).min(dist(i) + map((i, j)))
      }
    }

    val max = dist.max
    if (max == Int.MaxValue) -1 else max
  }
}