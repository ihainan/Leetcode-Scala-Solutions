package me.ihainan

object P1182 {
  def shortestDistanceColor(
      colors: Array[Int],
      queries: Array[Array[Int]]
  ): List[Int] = {
    val dp1 = Array.fill(colors.length, 4)(-1)
    val dp2 = Array.fill(colors.length, 4)(-1)
    (colors.length - 1 to 0 by -1).foreach { i =>
      val j = colors.length - i - 1
      dp1(i)(colors(i)) = i
      dp2(j)(colors(j)) = j
      if (i != colors.length - 1) {
        (1 to 3).foreach { c =>
          if (c != colors(i)) dp1(i)(c) = dp1(i + 1)(c)
          if (c != colors(j)) dp2(j)(c) = dp2(j - 1)(c)
        }
      }
    }

    queries.map { case Array(index, color) =>
      val (index1, index2) = (dp1(index)(color), dp2(index)(color))
      if (index1 == -1 && index2 == -1) -1
      else if (index1 == -1) index - index2
      else if (index2 == -1) index1 - index
      else (index - index2).min(index1 - index)
    }.toList
  }
}
