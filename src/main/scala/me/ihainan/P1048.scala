package me.ihainan

object P1048 {
  def incremental(s1: String, s2: String): Boolean = {
    var (i, diff) = (0, 0)
    s1.foreach { c =>
      while (i < s2.length && s2(i) != c) {
        diff += 1
        i += 1
      }
      i += 1
      if (diff > 1) return false
    }
    diff <= 1
  }

  def longestStrChain(words: Array[String]): Int = {
    val map =
      collection.mutable.TreeMap.empty[Int, List[Int]].withDefaultValue(Nil)
    words.indices.foreach { i =>
      map(words(i).length) = map(words(i).length) :+ i
    }
    val dp = Array.fill(words.length)(1)
    val lens = map.keys.toList
    var ans = 1
    (1 until lens.length).foreach { i =>
      val l = lens(i)
      map(l).foreach { j =>
        map(l - 1).foreach { k =>
          if (incremental(words(k), words(j))) {
            dp(j) = dp(j).max(dp(k) + 1)
          }
        }
        ans = ans.max(dp(j))
      }
    }
    ans
  }
}
