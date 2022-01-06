package me.ihainan

object P452 {
  def findMinArrowShots(points: Array[Array[Int]]): Int = {
    val s1 = points.zipWithIndex.sortBy { case (p, i) => p(0) }
    val s2 = points.zipWithIndex.sortBy { case (p, i) => p(1) }
    val set = collection.mutable.Set.empty[Int]
    var j = 0
    var ans = 0
    s2.indices.foreach { i =>
      if (!set(s2(i)._2)) {
        while (j < s1.length && s1(j)._1(0) <= s2(i)._1(1)) {
          set += s1(j)._2
          j += 1
        }
        ans += 1
      }
    }
    ans
  }
}
