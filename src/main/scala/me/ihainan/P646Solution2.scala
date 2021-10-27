package me.ihainan

object P646Solution2 {
  def findLongestChain(pairs: Array[Array[Int]]): Int = {
    val sorted = pairs.sortWith { case (p1, p2) =>
      if (p1(0) == p2(0)) p1(1) < p2(1)
      else p1(0) < p2(0)
    }

    var (len, current) = (0, Int.MinValue)
    sorted.foreach { pair =>
      if (pair(0) > current) {
        len += 1
        current = pair(1)
      } else if (pair(1) < current) current = pair(1)
    }

    len
  }
}
