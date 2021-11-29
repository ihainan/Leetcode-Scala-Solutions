package me.ihainan

object P438 {
  def findAnagrams(s: String, p: String): List[Int] = {
    if (p.length > s.length) return List.empty[Int]
    var cnt = new Array[Int](26)
    val ans = collection.mutable.ListBuffer.empty[Int]
    p.indices.foreach { i =>
      cnt(p(i) - 'a') -= 1
      cnt(s(i) - 'a') += 1
    }
    var diff = cnt.count(_ != 0)
    if (diff == 0) ans += 0

    (p.length until s.length).foreach { i =>
      val add = s(i) - 'a'
      val remove = s(i - p.length) - 'a'
      if (add != remove) {
        if (cnt(add) == 0) diff += 1
        if (cnt(remove) == 0) diff += 1
        cnt(add) += 1
        cnt(remove) -= 1
        if (cnt(add) == 0) diff -= 1
        if (cnt(remove) == 0) diff -= 1
      }
      if (diff == 0) ans += i - p.length + 1
    }

    ans.toList
  }
}
