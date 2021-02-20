package me.ihainan

object R0105 {
  // O(N)
  def oneEditAway(first: String, second: String): Boolean = {
    val (l1, l2) = (first.length, second.length)
    if ((l1 - l2).abs > 1) false
    else if (l1 <= l2) compare(first, second)
    else compare(second, first)
  }

  def compare(ss: String, ls: String): Boolean = {
    var (i, j) = (0, 0)
    var flag = false
    while (i < ss.length && j < ls.length) {
      if (ss(i) == ls(j)) i += 1
      else {
        if (!flag) {
          flag = true
          if (ss.length == ls.length) i += 1
        } else return false
      }
      j += 1
    }
    true
  }
}
