package me.ihainan

object P1055 {
  def shortestWay(source: String, target: String): Int = {
    var (i, ans) = (0, 0)
    while (i < target.length) {
      var start = i
      source.indices.foreach { j =>
        if (i < target.length && source(j) == target(i)) i += 1
      }
      if (start == i) return -1
      else ans += 1
    }
    ans
  }
}
