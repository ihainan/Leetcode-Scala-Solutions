package me.ihainan

object P743Solution2 {
  def networkDelayTime(times: Array[Array[Int]], n: Int, k: Int): Int = {
    val distance = Array.fill(n)(Int.MaxValue)
    distance(k - 1) = 0
    val map = times.map(time => (time(0) - 1, time(1) - 1) -> time(2)).toMap.withDefaultValue(Int.MaxValue)
    val visited = collection.mutable.Set.empty[Int]

    (0 until n).foreach { i =>
      var i = -1
      (0 until n).foreach { j => if (!visited(j) && (i == -1 || distance(j) < distance(i))) i = j }
      visited += i
      if (distance(i) == Int.MaxValue) return -1
      (0 until n).foreach { j => if (map((i, j)) != Int.MaxValue) distance(j) = distance(j).min(distance(i) + map((i, j))) }
    }

    distance.max
  }
}