package me.ihainan

object P678 {
  def checkValidString(s: String): Boolean = {
    var set = Set(0)
    s.foreach { c =>
      if (c == '(') set = set.map(_ + 1)
      else if (c == ')') set = set.map(_ - 1)
      else set = set.flatMap(v => Array(v, v + 1, v - 1))

      set = set.filter(v => v <= 100 && v >= 0)
      if (set.isEmpty) return false
    }
    set(0)
  }
}
