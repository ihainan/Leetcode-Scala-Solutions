package me.ihainan

object P495 {
  def findPoisonedDuration(timeSeries: Array[Int], duration: Int): Int = {
    var (ans, end) = (0, 0)
    timeSeries.foreach { ts =>
      if (ts >= end) ans += duration
      else ans += duration - end + ts
      end = end.max(ts + duration)
    }
    ans
  }
}
