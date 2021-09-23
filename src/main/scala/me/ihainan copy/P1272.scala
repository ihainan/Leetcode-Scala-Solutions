package me.ihainan

object P1272 {
  def removeInterval(intervals: Array[Array[Int]], toBeRemoved: Array[Int]): List[List[Int]] = {
    val ans = collection.mutable.ListBuffer.empty[List[Int]]
    intervals.foreach { interval =>
      if (interval(1) < toBeRemoved(0) || interval(0) > toBeRemoved(1)) ans += List(interval(0), interval(1))
      else {
        if (interval(0) < toBeRemoved(0)) ans += List(interval(0), toBeRemoved(0))
        if (interval(1) > toBeRemoved(1)) ans += List(toBeRemoved(1), interval(1))
      }
    }
    ans.toList
  }
}