package me.ihainan

import scala.collection.mutable.Map

object P76 {
  def minWindow(s: String, t: String): String = {
    var l = 0
    val ans = Array(-1, -1)
    var min = Int.MaxValue
    val map = Map.empty[Char, Int].withDefaultValue(0)
    t.foreach { c => map(c) = map(c) + 1 }

    s.indices.foreach { r =>
      if (map.isDefinedAt(s(r))) map(s(r)) = map(s(r)) - 1
      while (!map.values.exists(v => v > 0)) {
        if (min > r - l + 1) {
          min = r - l + 1
          ans(0) = l
          ans(1) = r
        }

        if (map.isDefinedAt(s(l))) map(s(l)) = map(s(l)) + 1
        l += 1
      }
    }

    if (ans(0) == -1) ""
    else s.substring(ans(0), ans(1) + 1)
  }
}