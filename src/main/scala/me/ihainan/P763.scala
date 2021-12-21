package me.ihainan

object P763 {
  def partitionLabels(s: String): List[Int] = {
    val range = Array.fill(26)(Array(-1, -1))
    s.indices.foreach { i =>
      val num = s(i) - 'a'
      if (range(num)(0) == -1) range(num)(0) = i
      range(num)(1) = i
    }

    val sorted =
      (0 until 26).filter(i => range(i)(0) != -1).sortBy(i => range(i)(0))

    var r = (range(sorted(0)))
    val ans = collection.mutable.ListBuffer.empty[Int]
    (1 until sorted.length).foreach { i =>
      val pos = sorted(i)
      if (range(pos)(0) > r(1)) {
        ans += r(1) - r(0) + 1
        r = range(pos)
      } else {
        r(1) = r(1).max(range(pos)(1))
      }
    }
    ans += r(1) - r(0) + 1
    ans.toList
  }
}
