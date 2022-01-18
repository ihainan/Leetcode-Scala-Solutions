package me.ihainan

object P539 {
  def findMinDifference(timePoints: List[String]): Int = {
    val total = 24 * 60
    if (timePoints.length > total) return 0
    val sorted = timePoints
      .map(t => t.substring(0, 2).toInt * 60 + t.substring(3, t.length).toInt)
      .sorted.toArray
    var ans = Int.MaxValue
    sorted.indices.foreach { i =>
      if (i == 0) ans = ans.min(sorted(0) + total - sorted.last)
      else ans = ans.min(sorted(i) - sorted(i - 1))
    }
    ans
  }
}