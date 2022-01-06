package me.ihainan

object P452Solution2 {
  def findMinArrowShots(points: Array[Array[Int]]): Int = {
    val sorted = points.zipWithIndex.sortBy(_._1.apply(1))
    var ans = 1
    var end = sorted.head._1.apply(1)
    sorted.foreach { case (Array(s, e), _) =>
      if (s > end) {
        ans += 1
        end = e
      }
    }
    ans
  }
}
