package me.ihainan

object P825 {
  def numFriendRequests(ages: Array[Int]): Int = {
    val sorted = ages.sorted

    @annotation.tailrec
    def findFirst(l: Int, r: Int, target: Double): Int = {
      if (l > r) -1
      else if (sorted(l) > target) l
      else {
        val m = (l + r) >>> 1
        if (sorted(m) > target) findFirst(l + 1, m, target)
        else findFirst(m + 1, r, target)
      }
    }

    @annotation.tailrec
    def findLast(l: Int, r: Int, target: Double): Int = {
      if (l > r) -1
      else if (sorted(r) > target) r
      else {
        val m = (l + r) >>> 1
        if (sorted(m) > target) findLast(m, r - 1, target)
        else findLast(l, m - 1, target)
      }
    }

    var lastIndex = -1
    (sorted.length - 1 to 0 by -1).map { i =>
      if (i == sorted.length - 1 || sorted(i) != sorted(i + 1)) lastIndex = i
      val target = 0.5 * sorted(i) + 7
      val first = findFirst(0, lastIndex, target)
      if (first == -1) 0
      else {
        val last = findLast(0, lastIndex, target)
        if (last >= i) last - first
        else last - first + 1
      }
    }.sum
  }
}
