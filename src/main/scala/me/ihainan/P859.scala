package me.ihainan

object P859 {
  def buddyStrings(s: String, goal: String): Boolean = {
    if (s.length != goal.length) return false
    var chars = new Array[Char](4)
    var count = 0
    val map = collection.mutable.Map.empty[Char, Int].withDefaultValue(0)
    s.indices.foreach { i =>
      map(s(i)) += 1
      if (s(i) != goal(i)) {
        if (count == 2) return false
        else {
          chars(count * 2) = s(i)
          chars(count * 2 + 1) = goal(i)
        }
        count += 1
      }
    }

    (count == 0 && map.values.exists(_ > 1)) ||
    (count == 2 && chars(0) == chars(3) && chars(1) == chars(2))
  }
}
