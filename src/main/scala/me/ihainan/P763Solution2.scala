package me.ihainan

object P763Solution2 {
  def partitionLabels(s: String): List[Int] = {
    val last = new Array[Int](26)
    val ans = collection.mutable.ListBuffer.empty[Int]
    s.indices.foreach(i => last(s(i) - 'a') = i)
    var (start, max) = (0, 0)
    s.indices.foreach { i =>
      max = max.max(last(s(i) - 'a'))
      if (i == max) {
        ans += i - start + 1
        start = i + 1
      }
    }
    ans.toList
  }
}
