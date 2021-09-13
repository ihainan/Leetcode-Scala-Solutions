package me.ihainan

object P447 {
  def numberOfBoomerangs(points: Array[Array[Int]]): Int = {
    var ans = 0
    points.foreach { case Array(x, y) =>
      val map = collection.mutable.Map.empty[Int, Int].withDefaultValue(0)
      points.foreach { case Array(x2, y2) =>
        val distance = (x2 - x) * (x2 - x) + (y2 - y) * (y2 - y)
        map(distance) = map(distance) + 1
      }
      ans += map.values.map(v => v * (v - 1)).sum
    }
    ans
  }
}
